package com.jay.kafka.basics;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.Properties;

public class Producer {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        final String TOPIC = "mytopic";

        try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer(properties)) {

            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC, "Hello from Java");

            kafkaProducer.send(producerRecord);

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Done...");
    }
}
