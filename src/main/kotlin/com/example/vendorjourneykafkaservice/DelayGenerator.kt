package com.example.vendorjourneykafkaservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.web.bind.annotation.RestController
import org.springframework.kafka.core.KafkaTemplate

import org.springframework.beans.factory.annotation.Autowired

@RestController
class DelayGenerator {

    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>? = null

    private val logger: Logger = LoggerFactory.getLogger(DelayGenerator::class.java)

    @KafkaListener(topics = ["receivedApplicationId"], groupId = "myGroupId")
    fun getApplicationId(applicationId: String) {
        logger.info("In getApplicationId method with ID:- $applicationId")
        generateDelayEvent(applicationId)
    }

    fun generateDelayEvent(applicationId: String){
        logger.info("In generateDelayEvent with ID:- $applicationId")
        Thread.sleep(20000)
        kafkaTemplate?.send("updateApplicationStatus", applicationId)
    }
}
