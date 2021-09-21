package com.example.sinkconnector;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class SingleFilesSinkConnectorConfig extends AbstractConfig {

    public static final String DIR_FILE_NAME = "file";
    public static final String DIR_FILE_NAME_DEFAULT_VALUE = "file";
    public static final String DIR_FILE_NAME_DOC = "file";

    //사용할 옵션값에 대한 정의
    public static ConfigDef CONFIG = new ConfigDef()
            .define(DIR_FILE_NAME, ConfigDef.Type.STRING,DIR_FILE_NAME_DEFAULT_VALUE, ConfigDef.Importance.HIGH,DIR_FILE_NAME_DOC);

    public SingleFilesSinkConnectorConfig(Map<String, String> props) {
        super(CONFIG, props);
    }

}
