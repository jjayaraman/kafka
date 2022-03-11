package com.jai.kafka.service;

import com.jai.kafka.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final String TOPIC_STRING = "topic-string";
    private final String TOPIC_JSON = "topic-json";

    @KafkaListener(topics = TOPIC_STRING, groupId = "group-string")
    public void stringMessageListener(String message) {
        System.out.println("Listener " + message);
    }

    @KafkaListener(topics = TOPIC_JSON, groupId = "group-json", containerFactory = "userJSONContainerFactory")
    public User jsonMessageListener(User user) {
        System.out.println(user);
        return user;
    }


}

