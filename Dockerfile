# Temel imaj olarak OpenJDK 11 kullanıyoruz
FROM openjdk:11-jre-slim

# Uygulamanızın jar dosyasını kopyalayacağınız dizin
WORKDIR /app

# JAR dosyanızı Docker imajına kopyalayın
COPY target/kafka-postgres-integration-1.0-SNAPSHOT.jar kafka-postgres-integration-1.0-SNAPSHOT.jar

# Uygulamayı çalıştırmak için gerekli komut
ENTRYPOINT ["java", "-jar", "myapp.jar"]

