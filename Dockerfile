# dockerfile
FROM maven:3.9.7-eclipse-temurin-17 AS build

WORKDIR /app
# copy only what is needed to leverage layer cache
COPY pom.xml .
COPY src ./src
COPY public ./public

RUN mvn -q -DskipTests package

FROM eclipse-temurin:17-jdk

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
