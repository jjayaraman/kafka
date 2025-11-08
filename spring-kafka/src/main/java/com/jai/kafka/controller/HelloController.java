package com.jai.kafka.controller;

import com.jai.kafka.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "kafka")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private final ProducerService producerService;

    // Spring constructor injection
    public HelloController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(path = "/publish")
    public void produceMessage(@RequestParam String topic, @RequestParam String message) {
        producerService.sendMessage(topic, message);
        logger.info("Message published to topic: " + topic);
    }

    // GET mapping for easy browser testing
    @GetMapping(path = "/publish")
    public String produceMessageGet(@RequestParam String topic, @RequestParam String message) {
        producerService.sendMessage(topic, message);
        logger.info("Message published to topic: " + topic);
        return "Message published to topic: " + topic + " with message: " + message;
    }
}
