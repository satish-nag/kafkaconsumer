package com.example.kafkaconsumer.config;

import com.example.kafkaproducer.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class AppConfig {

    @KafkaListener(topics = "#{'${app.topicName}'.split(',')}")
    public void kafkaListener(ConsumerRecord<?, Product> product){
        log.info("Message received: "+product.value());
    }

}
