package com.example.vendorjourneykafkaservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.web.bind.annotation.RestController
import org.springframework.kafka.core.KafkaTemplate

import org.springframework.beans.factory.annotation.Autowired

@RestController
class ConsumerProducer {

    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>? = null

    private val logger: Logger = LoggerFactory.getLogger(ConsumerProducer::class.java)

    @KafkaListener(topics = ["t3"], groupId = "myGroupId")
    fun getTopics(e: String) :Unit{
        logger.info("In get Topic method with ID:- $e")
        delayGenerateEvent(e)
    }

    fun delayGenerateEvent(c:String){
        logger.info("In delayGenerateEvent with ID:- $c")
        Thread.sleep(20000)
        kafkaTemplate?.send("t4", c)
    }
}
