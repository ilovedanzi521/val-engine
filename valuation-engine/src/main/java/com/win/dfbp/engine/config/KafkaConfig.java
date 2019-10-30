package com.win.dfbp.engine.config;

import com.win.dfbp.engine.util.KafkaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@ConfigurationProperties("kafka")
public class KafkaConfig {

    private String bootstrapServers;
    private String groupId;
    private String enableAutoCommit;
    private String autoCommitIntervalMs;
    private String autoOffsetReset;
    private String sessionTimeoutMs;
    private String keyDeserializer;
    private String valueDeserializer;
    private String topic;
    private String apiUrl;

    @Bean(name ="kproperties")
    private Properties kafkaProperties(){
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", getBootstrapServers());
        properties.setProperty("group.id", getGroupId());
        properties.setProperty("enable.auto.commit", getEnableAutoCommit());
        properties.setProperty("auto.commit.interval.ms", getAutoCommitIntervalMs());
        properties.setProperty("auto.offset.reset", getAutoOffsetReset());
        properties.setProperty("session.timeout.ms", getSessionTimeoutMs());
        properties.setProperty("key.deserializer", getKeyDeserializer());
        properties.setProperty("value.deserializer", getValueDeserializer());
        properties.setProperty("topic", KafkaUtils.createTopic(getBootstrapServers(),getTopic()));
        properties.setProperty("apiUrl", getApiUrl());
        return properties;
    }

    private String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getEnableAutoCommit() {
        return enableAutoCommit;
    }

    public void setEnableAutoCommit(String enableAutoCommit) {
        this.enableAutoCommit = enableAutoCommit;
    }

    public String getAutoCommitIntervalMs() {
        return autoCommitIntervalMs;
    }

    public void setAutoCommitIntervalMs(String autoCommitIntervalMs) {
        this.autoCommitIntervalMs = autoCommitIntervalMs;
    }

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    public String getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }

    public void setSessionTimeoutMs(String sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
    }

    public String getKeyDeserializer() {
        return keyDeserializer;
    }

    public void setKeyDeserializer(String keyDeserializer) {
        this.keyDeserializer = keyDeserializer;
    }

    public String getValueDeserializer() {
        return valueDeserializer;
    }

    public void setValueDeserializer(String valueDeserializer) {
        this.valueDeserializer = valueDeserializer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
