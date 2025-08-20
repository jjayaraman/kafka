package com.jay.kafka.streams;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;


import java.util.Properties;


public class HelloStream {

    final static String SOURCE_TOPIC = "source_topic";
    final static String DEST_TOPIC = "dest_topic";

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "hello_app");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder streamsBuilder = new StreamsBuilder();

        streamsBuilder.stream(SOURCE_TOPIC).filter((key, value) -> value.toString().length() > 3).to(DEST_TOPIC);

        System.out.println("Topology ::" + streamsBuilder.build().describe());

        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), properties);
        kafkaStreams.start();

        System.out.println("Done...");
    }
}
