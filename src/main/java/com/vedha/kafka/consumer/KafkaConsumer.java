package com.vedha.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    //private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = { "${kafka.topic.serializer.string.name}" }, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {

        log.error(String.format("Message Received From Topic vedha(vedhaGroup) : %s", message));
    }
}
