FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
EXPOSE 9191
COPY target/gittest.jar gittest.jar
ENTRYPOINT ["java", "-jar", "gittest.jar"]