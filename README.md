-Proje yapısını oluştururken maven ile oluşturdum 
mvn archetype:generate -DgroupId=com.example -DartifactId=kafka-postgres-integration -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
-Kafka ve PostgreSQL bağımlılıklarını projeme eklemek için pom.xml dosyası oluşturuyorum ve ekliyorum
-application.properties adında bir dosya oluşturdum ve buraya Kafka ve PostgreSQL bağlantı ayarlarını yazıyorum
-Sipariş verilerini göndermesi için Order.Producer.java adında bir dosya oluşturdum 
-Sipariş verilerini PostgreSQL de kaydetmesi için de Order.Consumer.java adında bir dosya oluşturdum
-PostgreSQL üzerinde bir veritabanı ve tablo oluşturdum
-Kafka producer ve consumer ı çalıştırmak için App.java adında bir dosya oluşturdum
-Mvn ile projeyi derleyip çalıştırdım
-Docker ile çalıştırmak için Dockerfile ve docker-compose dosyası oluşturdum ve build ettim
-Oluşturduğum docker image i dockerhub a push ettim
-Kubernetes üzerinde bu image i çalıştırmak için yaml uzantılı bir deployment dosyası oluşturdum
-Son olarak kubectl apply -f deployment.yaml komutunu yazarak uygulamaya geçirdim
