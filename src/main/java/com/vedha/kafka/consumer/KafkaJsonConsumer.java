package com.vedha.kafka.consumer;

import com.vedha.kafka.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaJsonConsumer {

    //private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = { "${kafka.topic.serializer.json.name}" }, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(UserDTO userDTO) { // UserDTO should be in default constructor and getter and setter

        log.error("Json Message Received From Topic vedha-json(vedhaGroup) : " + userDTO);

    }
}
