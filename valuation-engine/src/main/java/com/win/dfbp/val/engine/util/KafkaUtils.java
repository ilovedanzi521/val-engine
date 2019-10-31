package com.win.dfbp.val.engine.util;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicListing;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.ExecutionException;


public class KafkaUtils {

    public static String createTopic(String bootstrapServers , String topic){
        AdminClient adminClient = null;
        try {
            Properties properties = new Properties();
            properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
            adminClient = AdminClient.create(properties);
            if(!topicExists(bootstrapServers,topic)){
                NewTopic newTopic = new NewTopic(topic,4, (short) 1);
                Collection<NewTopic> newTopicList = new ArrayList<>();
                newTopicList.add(newTopic);
                adminClient.createTopics(newTopicList);
            }
        } finally {
            if(adminClient != null) {
                adminClient.close();
            }
        }
        return topic;
    }

    public static boolean topicExists(String bootstrapServers  , String topic) {
        AdminClient adminClient = null;
        try {
            Properties properties = new Properties();
            properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
            adminClient = AdminClient.create(properties);
            ListTopicsResult result = adminClient.listTopics();
            if(result != null){
                Collection<TopicListing> list = result.listings().get();
                for (TopicListing tl:list) {
                    String name = tl.name();
                    if(topic.equals(name)){
                        return true;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            if(adminClient != null) {
                adminClient.close();
            }
        }
        return false;
    }

    public static void writeToKafka(KafkaProperties kafkaProperties,String topic,String data) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", kafkaProperties.getBootstrapServers());
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer producer = new KafkaProducer<String, String>(props);
        ProducerRecord record = new ProducerRecord<String, String>(topic, null, null, data);
        producer.send(record);
        //System.out.println("发送数据: " + data);
        producer.flush();
    }
}
