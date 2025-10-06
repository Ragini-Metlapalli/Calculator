FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/Calculator-1.0-SNAPSHOT.jar app.jar
ENV JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8 -Dstdout.unbuffered=true"
ENTRYPOINT ["java", "-jar", "app.jar"]