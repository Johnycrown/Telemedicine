#FROM openjdk:17
#VOLUME /tmp
#EXPOSE 8083
#ADD target/spring-boot-docker.jar app.jar
#
#ENTRYPOINT ["java","-jar","app.jar"]
# First stage: Build the application
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Second stage: Create the actual image for running the application
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the first stage
COPY --from=build /app/target/spring-boot-docker.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8082

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
