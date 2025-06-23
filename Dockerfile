FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
EXPOSE 8080
COPY target/ai-doc-summarizer.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
