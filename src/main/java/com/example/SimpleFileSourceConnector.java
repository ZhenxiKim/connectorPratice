package com.example;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.source.SourceConnector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleFileSourceConnector extends SourceConnector {

    private Map<String,String> configProperties;

    @Override
    public String version() {
        return "1.0";
    }

    @Override
    public void start(Map<String, String> props) {
        this.configProperties = props;
        try{
            //커넥터 생성 시 받은 설정값 초기화
            new SimpleFileSourceConnectorConfig(props);
        }catch (ConfigException e){
            throw new ConnectException(e.getMessage(),e);
        }
    }

    @Override
    public Class<? extends Task> taskClass() {
        //사용할 태스크의클래스이름 지정
        return SimpleFileSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        //태스크가 2개 이상일 경우 설정값 추가
        List<Map<String,String>> taskConfigs = new ArrayList<>();
        Map<String,String> taskProps = new HashMap<>();
        taskProps.putAll(configProperties);
        for (int i =0; i< maxTasks; i ++){
            taskConfigs.add(taskProps);
        }
        return taskConfigs;
    }

    @Override
    public void stop() {

    }

    @Override
    public ConfigDef config() {
        //커넥터에서 사용할 설정값 지정
        return SimpleFileSourceConnectorConfig.CONFIG;
    }
}
