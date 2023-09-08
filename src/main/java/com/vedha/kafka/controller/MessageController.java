package com.vedha.kafka.controller;

import com.vedha.kafka.dto.UserDTO;
import com.vedha.kafka.producer.KafkaJsonProducer;
import com.vedha.kafka.producer.KafkaProducer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@AllArgsConstructor
@Tag(name = "Message Controller", description = "Kafka Message Controller")
public class MessageController {

    private final KafkaProducer kafkaProducer;

    private final KafkaJsonProducer kafkaJsonProducer;

    // http://localhost:8080/api/kafka/sendMessage?message=Hi Vedha
    @Operation(summary = "Send String Message", description = "Send String Message To Kafka")
    @ApiResponse(responseCode = "200", description = "Http Status 200 Ok")
    @GetMapping(value = { "/sendMessage" })
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {

        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("String Message Sent To Topic vedha : " + message);
    }

    // http://localhost:8080/api/kafka/sendJsonMessage
    @Operation(summary = "Send Json Message", description = "Send Json Message To Kafka")
    @ApiResponse(responseCode = "200", description = "Http Status 200 Ok")
    @PostMapping(value = { "sendJsonMessage" }, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> sendJsonMessage(@RequestBody UserDTO userDTO) {

        kafkaJsonProducer.sendJsonMessage(userDTO);

        return ResponseEntity.ok("Json Message Sent To Topic vedha-json : " + userDTO);
    }
}
