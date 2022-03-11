package com.jai.kafka.controller;

import com.jai.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topic-string
 */
@RestController
public class ProducerController {

    private final String TOPIC_STRING = "topic-string";
    private final String TOPIC_JSON = "topic-json";
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping(value = "/produce/string/{data}")
    public String produceString(@PathVariable String data) {

        kafkaTemplate.send(TOPIC_STRING, data);
        return data;
    }

    @GetMapping(value = "/produce/json/{name}")
    public User produceJson(@PathVariable String name) {
        User user = new User(name, "London");
        kafkaTemplate.send(TOPIC_JSON, user);
        return user;
    }
}
