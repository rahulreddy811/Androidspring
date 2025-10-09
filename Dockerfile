FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy pre-built JAR
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
