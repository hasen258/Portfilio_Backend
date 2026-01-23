# Stage 1: Build with Maven
FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml and src from the demo subdirectory
COPY demo/pom.xml .
COPY demo/src ./src

RUN mvn clean package -DskipTests

# Stage 2: Run the JAR
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Use a wildcard to copy the generated JAR
COPY --from=build /app/target/*.jar backend.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "backend.jar"]
