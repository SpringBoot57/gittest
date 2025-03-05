FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

COPY target/gittest.jar gittest.jar

LABEL authors="Admin"

ENTRYPOINT ["java", "-jar", "gittest.jar"]