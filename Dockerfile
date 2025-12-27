FROM eclipse-temurin:17-jdk as build

WORKDIR /app
COPY . .

RUN apt-get update && apt-get install -y maven
RUN mvn -q -e -DskipTests package


FROM eclipse-temurin:17-jdk

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-Djavax.net.ssl.trustStore=/etc/ssl/certs/java/cacerts", "-Djavax.net.ssl.trustStorePassword=changeit", "-Dhttps.protocols=TLSv1.2", "-jar", "app.jar"]

