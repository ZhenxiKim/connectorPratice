package com.example;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class SimpleFileSourceConnectorConfig extends AbstractConfig {

    public static final String DIR_FILE_NAME = "file";
    public static final String DIR_FILE_NAME_DEFAULT_VALUE = "file";
    public static final String DIR_FILE_NAME_DOC = "file";

    //보낼 토픽을 정보 저장
    public static final String TOPIC_NAME = "file";
    public static final String TOPIC_DEFAULT_VALUE = "file";
    public static final String TOPIC_DOC = "file";

    //커넥터에서 사용할 옵션값에 대한 정의
    public static ConfigDef CONFIG = new ConfigDef()
            .define(DIR_FILE_NAME, ConfigDef.Type.STRING,DIR_FILE_NAME_DEFAULT_VALUE, ConfigDef.Importance.HIGH,DIR_FILE_NAME_DOC)
            .define(TOPIC_NAME, ConfigDef.Type.STRING,TOPIC_DEFAULT_VALUE, ConfigDef.Importance.HIGH,TOPIC_DOC);


    public SimpleFileSourceConnectorConfig(Map<String, String> props) {
        super(CONFIG, props);
    }
}
