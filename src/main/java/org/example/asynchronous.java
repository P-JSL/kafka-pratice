package org.example;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class asynchronous implements Callback {
    @Override
    public void onCompletion(RecordMetadata metadata, java.lang.Exception e) {
        if(metadata != null){
            System.out.println("Partition : " + metadata.partition() + " , Offset :" + metadata.offset() + "");
        }else{
            e.printStackTrace();
        }
    }
}

