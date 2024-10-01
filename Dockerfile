# Temel imaj olarak OpenJDK 11 kullandım
FROM openjdk:11-jre-slim

# Uygulamanızın jar dosyasını kopyalayacağımız dizin
WORKDIR /app

# JAR dosyanızı Docker imajına kopyaladım
COPY target/kafka-postgres-integration-1.0-SNAPSHOT.jar kafka-postgres-integration-1.0-SNAPSHOT.jar

# Uygulamayı çalıştırmak için gerekli komutu yazdım
ENTRYPOINT ["java", "-jar", "myapp.jar"]

