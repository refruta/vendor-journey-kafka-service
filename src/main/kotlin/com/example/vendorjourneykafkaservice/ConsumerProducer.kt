package com.example.vendorjourneykafkaservice

import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.web.bind.annotation.RestController
import org.springframework.kafka.core.KafkaTemplate

import org.springframework.beans.factory.annotation.Autowired




@RestController
class ConsumerProducer {


    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>? = null

    @KafkaListener(topics = ["t3"], groupId = "myGroupId")
    fun getTopics(e: String) :Unit{
        println("In consumer $e")
        delayGenerateEvent(e)
    }

    fun delayGenerateEvent(c:String){
        print(c)
        Thread.sleep(20000)
        kafkaTemplate?.send("t4", c)
    }
}