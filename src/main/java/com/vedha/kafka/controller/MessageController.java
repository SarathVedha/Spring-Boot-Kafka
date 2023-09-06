package com.vedha.kafka.controller;

import com.vedha.kafka.dto.UserDTO;
import com.vedha.kafka.producer.KafkaJsonProducer;
import com.vedha.kafka.producer.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@AllArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    private final KafkaJsonProducer kafkaJsonProducer;

    // http://localhost:8080/api/kafka/sendMessage?message=Hi Vedha
    @GetMapping(value = { "/sendMessage" })
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {

        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("String Message Sent To Topic vedha : " + message);
    }

    // http://localhost:8080/api/kafka/sendJsonMessage
    @PostMapping(value = { "sendJsonMessage" }, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> sendJsonMessage(@RequestBody UserDTO userDTO) {

        kafkaJsonProducer.sendJsonMessage(userDTO);

        return ResponseEntity.ok("Json Message Sent To Topic vedha-json : " + userDTO);
    }
}
