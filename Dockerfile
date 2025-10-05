FROM openjdk:21-jdk-slim
WORKDIR /app

# Set JVM options to make stdout unbuffered and headless
ENV JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8 -Djava.awt.headless=true -Dstdout.unbuffered=true"

COPY target/Calculator-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
