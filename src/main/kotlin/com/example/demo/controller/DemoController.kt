package com.example.demo.controller

import com.example.demo.kafka.DemoProducer
import com.example.demo.model.UserMutation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(val demoProducer: DemoProducer) {

    @PostMapping("/sendMessages")
    fun sendMessages(
            @RequestBody
            body: UserMutation
    ) {
        demoProducer.produce(body)
    }
}
