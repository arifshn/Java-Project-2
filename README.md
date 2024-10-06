# Kafka ve PostgreSQL Entegrasyonu Projesi

Bu projede, Kafka kullanarak sipariş verilerini üreten ve PostgreSQL veritabanına kaydeden bir Java uygulaması geliştirdim. 

## Proje Yapısı

1. **Maven Projesi Oluşturma**:
   Proje yapısını oluşturmak için Maven kullanarak aşağıdaki komutu çalıştırdım:
   ```bash
   mvn archetype:generate -DgroupId=com.example -DartifactId=kafka-postgres-integration -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
2. **Bağımlılıkları Eklemek**:
   - Kafka ve PostgreSQL bağımlılıklarını projeme eklemek için pom.xml dosyası oluşturuyorum ve gerekli bağımlılıkları ekliyorum.
3. **Bağlantı Ayarları**:
   - application.properties adında bir dosya oluşturdum ve burada Kafka ile PostgreSQL bağlantı ayarlarını yazıyorum.
4. **Producer ve Consumer Dosyaları**:
   - Sipariş verilerini göndermesi için Order.Producer.java adında bir dosya oluşturdum.
   - Sipariş verilerini PostgreSQL'e kaydetmesi için Order.Consumer.java adında bir dosya oluşturdum.
5. **Veritabanı Oluşturma**:
   - PostgreSQL üzerinde gerekli veritabanı ve tabloyu oluşturdum.
6. **Ana Uygulama Dosyası**:
   - Kafka producer ve consumer'ı çalıştırmak için App.java adında bir dosya oluşturdum.
7. **Projeyi Derleyip Çalıştırma**:
   - Projeyi derlemek ve çalıştırmak için Maven kullanarak aşağıdaki komutu çalıştırdım.
    ```bash
    mvn clean install
8. **Docker ile Çalıştırma**:
   - Docker ile projeyi çalıştırmak için Dockerfile ve docker-compose.yml dosyası oluşturdum ve build ettim. Projeyi çalıştırmak için aşağıdaki komutu kullandım.
   ```bash
   docker-compose up --build
9. **Docker Hub'a Push Etme**:
   - Oluşturduğum Docker imajını Docker Hub'a push ettim:
   ```bash
   docker tag kafka-postgres-integration:latest yourusername/kafka-postgres-integration:latest
   docker push yourusername/kafka-postgres-integration:latest
10. **Kubernetes ile Dağıtım**:
    - Kubernetes üzerinde bu imajı çalıştırmak için .yaml uzantılı bir deployment dosyası oluşturdum. Deployment dosyası içeriğini yazdıktan sonra uygulamaya geçmek için aşağıdaki komutu kullandım.
    ```bash
    kubectl apply -f deployment.yaml
