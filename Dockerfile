FROM openjdk:21-jdk-slim

WORKDIR /app

COPY . .

RUN ./mvnw clean install

EXPOSE 8080

CMD ["java", "-jar", "target/carritoApp-0.0.1-SNAPSHOT.jar"]

