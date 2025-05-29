FROM openjdk:17-jdk-slim

# Instalar curl para healthcheck
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY target/*.jar app.jar

ENV JAVA_OPTS="-XX:+UnlockExperimentalVMOptions \
               -Djava.security.egd=file:/dev/./urandom \
               -Dspring.jmx.enabled=false"

EXPOSE 8761

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]