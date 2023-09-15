package com.example.demo.kafka

import com.example.demo.logging.logger
import com.example.demo.model.UserMutation
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import java.time.format.DateTimeFormatter

@Component
class DemoProducer(
        private val kafkaTemplate: KafkaTemplate<String, UserMutation>,
        @Value("\${demo.kafka.user-mutation.topic.name}")
        private val topic: String
) {

    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")

    fun produce(message: UserMutation, headers: Map<String, Any?> = emptyMap()) {
        logger.info("Send message to topic {} with headers {}.", topic, headers)
        val future = kafkaTemplate.send(topic, message)
        future.whenComplete { result: SendResult<String, UserMutation>, ex: Throwable? ->
            if (ex == null) {
                System.out.println("Sent message=[$message" +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]")
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.message)
            }
        }
    }
}
