# Stage 1 — Build Stage
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /workspace
COPY . .
RUN mvn clean package -DskipTests

# Stage 2 — Runtime Stage
FROM eclipse-temurin:17-jdk-slim
WORKDIR /app
COPY --from=builder /workspace/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
