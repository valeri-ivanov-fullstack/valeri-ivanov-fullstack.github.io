# Step 1: Build the application with the latest stable Gradle and JDK
FROM gradle:8.3.0-jdk21 AS build  # Using Gradle 8.3 with JDK 21
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle clean build -x test

# Step 2: Run the application using the latest stable lightweight Java image
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
