# Use a valid JDK 17 base image
FROM eclipse-temurin:17-jdk as build

WORKDIR /app
COPY . .

RUN ./mvnw -q -e -DskipTests package

FROM eclipse-temurin:17-jdk

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
