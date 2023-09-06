package com.vedha.kafka.producer;

import com.vedha.kafka.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaJsonProducer {

    //private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private final KafkaTemplate<String, UserDTO> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, UserDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.topic.serializer.json.name}")
    private String topicName;

    public void sendJsonMessage(UserDTO userDTO) {

        log.error("User DTO : " + userDTO);

        Message<UserDTO> message = MessageBuilder.withPayload(userDTO).setHeader(KafkaHeaders.TOPIC, topicName).build();

        log.error("Message : " + message);

        kafkaTemplate.send(message);
    }
}
