package com.example;

import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/*
* 소스파일로부터 읽고 토픽을 보낸 지점을 기록하고 읽는다.
* 위치는 오프셋 스토리지에 저장
* */
public class SimpleFileSourceTask extends SourceTask {

    private Logger logger = LoggerFactory.getLogger(SimpleFileSourceTask.class);

    public final String FILENAME_FILED = "filename";
    public final String POSITION_FILED = "position";
    private String topic;
    private String file;
    private long position;

    @Override
    public String version() {
        return "1.0";
    }

    @Override
    public void start(Map<String, String> props) {

    }

    @Override
    public List<SourceRecord> poll() throws InterruptedException {
        return null;
    }

    @Override
    public void stop() {

    }
}
