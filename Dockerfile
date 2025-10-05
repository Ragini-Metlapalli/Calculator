FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/Calculator-1.0-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Dfile.encoding=UTF-8", "-jar", "app.jar"]