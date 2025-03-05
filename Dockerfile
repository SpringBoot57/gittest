FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/gittest.jar gittest.jar

ENTRYPOINT ["java", "-jar", "gittest.jar"]