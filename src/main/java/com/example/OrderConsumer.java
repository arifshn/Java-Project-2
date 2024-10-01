package com.example;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class OrderConsumer {

    private KafkaConsumer<String, String> consumer;
    private String jdbcUrl;
    private String jdbcUser;
    private String jdbcPassword;

    public OrderConsumer(String topic, String bootstrapServers, String jdbcUrl, String jdbcUser, String jdbcPassword) {
        Properties props = new Properties();
        props.put("localhost:9092", bootstrapServers);
        props.put("group.id", "order-consumer-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topic));

        
        this.jdbcUrl = "jdbc:postgresql://localhost:5432/mydb";
        this.jdbcUser = "arif";
        this.jdbcPassword = String.valueOf(2743);
    }

    public void processOrders() {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)) {
            String insertOrderSQL = "INSERT INTO orders (order_id, order_data) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertOrderSQL);

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    pstmt.setString(1, record.key());
                    pstmt.setString(2, record.value());
                    pstmt.executeUpdate();
                    System.out.println("Sipariş kaydedildi: " + record.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

