package com.jay.kafka.basics;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;


import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class Consumer {

    final static String TOPIC = "mytopic";
    final static List<String> TOPICS = List.of(TOPIC);

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
//        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");  // To read from beginning

        try (KafkaConsumer kafkaConsumer = new KafkaConsumer(properties)) {

            kafkaConsumer.subscribe(TOPICS);

            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));

            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Data : " +record.value());
            }

            System.out.println("Done....");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
