package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // kafka server host 및 port
        props.put("session.timeout.ms", "10000"); // session 설정
        props.put("group.id", "quickstart-events");   // topic 설정
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");    // key deserializer
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");  // value deserializer

        Producer<String,String> producer = new KafkaProducer<>(props);
        try{
            RecordMetadata metadata = producer.send(new ProducerRecord<>("peter-topic","Apache Kafka")).get();
            System.out.printf("metadata: %s, Partition: %d, Offset: %s", metadata,metadata.partition(),metadata.offset());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            producer.close();
        }
    }
}