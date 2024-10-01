 package com.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class OrderProducer {

    private KafkaProducer<String, String> producer;
    private String topic;

    public OrderProducer(String topic, String bootstrapServers) {
        Properties props = new Properties();
        props.put("localhost:9092", bootstrapServers);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
        this.topic = topic;
    }

    public void sendOrder(String orderId, String orderData) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, orderId, orderData);
        producer.send(record);
        System.out.println("Sipariş gönderildi: " + orderData);
    }

    public void close() {
        producer.close();
    }
}

