package com.vedha.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    //private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    // @RequiredArgsConstructor will only create object with final variable
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.serializer.string.name}")
    private String topicName;

    public void sendMessage(String message) {

        log.error(String.format("Message sent : %s", message));

        kafkaTemplate.send(topicName, message);
    }

}
