package com.example.demo.kafka

import com.example.demo.logging.logger
import com.example.demo.model.UserMutation
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
class DemoConsumer {

    @KafkaListener(id = "kafkademo",
            topics = ["\${demo.kafka.user-mutation.topic.name}"],
            containerFactory = "kafkaListenerContainerFactory")
    fun receive(message: Message<UserMutation>) {
        logger.info("Received message: {}", message)
    }
}
