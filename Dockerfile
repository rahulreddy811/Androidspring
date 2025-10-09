# Use official OpenJDK 17 image as base
FROM openjdk:17-jdk-slim

# Set environment variables for Java
ENV JAVA_OPTS=""

# Set working directory inside container
WORKDIR /app

# Copy Maven build files
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Copy source code
COPY src src

# Copy Maven wrapper script
COPY mvnw mvnw

# Grant execution permission for mvnw
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Copy the built jar (Spring Boot default output location)
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Set environment variables for database (Render will inject these)
ENV DB_HOST=dpg-d3im4r6r433s73c6m41g-a.render.com
ENV DB_PORT=5432
ENV DB_NAME=androidspringdb
ENV DB_USERNAME=androidspringdb_user
ENV DB_PASSWORD=tMHb1IiRuD9rhlp63eiam6MgkI44ZIVf
ENV DB_SSLMODE=requires

# Run the Spring Boot application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
