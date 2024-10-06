package com.example;
import com.example.OrderProducer;
import com.example.OrderConsumer;
//.


public class App {
    public static void main(String[] args) {
        // Kafka Producer ile örnek bir sipariş gönderimi
        OrderProducer producer = new OrderProducer("orders", "localhost:9092");
        producer.sendOrder("1", "{\"product\": \"Laptop\", \"price\": 1000}");
        producer.close();

        // Kafka Consumer ile siparişlerin PostgreSQL'e kaydedilmesi
        OrderConsumer consumer = new OrderConsumer("orders", "localhost:9092",
                "jdbc:postgresql://localhost:5432/mydb", "arif", "2743");
        consumer.processOrders();
    }
}

