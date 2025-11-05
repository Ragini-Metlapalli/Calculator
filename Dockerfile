FROM openjdk:17
WORKDIR /app
COPY target/Calculator-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]