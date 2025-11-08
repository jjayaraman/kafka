# Stage1 - build the springboot app
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
RUN chmod +x gradlew
COPY . .
RUN ./gradlew build -x test

# Stage2 - Run the springboot app
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/build/libs/spring-kafka-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]
