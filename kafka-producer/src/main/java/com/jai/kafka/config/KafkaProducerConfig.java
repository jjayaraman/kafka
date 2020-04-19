package com.jai.kafka.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {


//    @Bean
//    public KafkaTemplate getKafkaTemplate() {
//        return new KafkaTemplate(getProducerFactory());
//    }
//
//    @Bean
//    public ProducerFactory<String, User> getProducerFactory() {
//        Map<String, Object> config = new HashMap<>();
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<String, User>(config);
//    }

}
