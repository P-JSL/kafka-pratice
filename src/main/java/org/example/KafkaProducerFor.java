package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerFor {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // kafka server host 및 port
        props.put("session.timeout.ms", "10000"); // session 설정
        props.put("group.id", "quickstart-events");   // topic 설정
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");    // key deserializer
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");  // value deserializer
        props.put("acks","1");
        props.put("compression.type","gzip");

        Producer<String,String> producer = new KafkaProducer<>(props);
        for(int i=1; i<11;i++){
            producer.send(new ProducerRecord<>("peter-topic","Apache Kafka"), new asynchronous());
        }
        producer.close();
    }
}
