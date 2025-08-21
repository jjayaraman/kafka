package com.jai.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "jay-topic", groupId = "group-1")
    public String receive(String message) {
        logger.info("Message received by consumer: " +message);
        return message;
    }
}
