FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/Calculator-1.0-SNAPSHOT.jar app.jar
COPY start.sh start.sh
RUN chmod +x start.sh
ENTRYPOINT ["./start.sh"]
