package com.vedha.kafka.configurations;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfigs {

    @Value("${kafka.topic.serializer.string.name}")
    private String stringTopicName;

    @Value("${kafka.topic.serializer.json.name}")
    private String jsonTopicName;

    @Bean
    NewTopic vedhaTopic() {

        return TopicBuilder.name(stringTopicName).build();
    }

    @Bean
    NewTopic vedhaJsonTopic() {

        return TopicBuilder.name(jsonTopicName).build();
    }
}
