# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory to /sourEarth
WORKDIR /sourEarth

# Copy the executable jar file and the application.properties file to the container
COPY /target/SoarEarthSpringProject-0.0.1-SNAPSHOT.jar /sourEarth/

# Set the command to run the Spring Boot application
CMD ["java", "-jar", "SoarEarthSpringProject-0.0.1-SNAPSHOT.jar"]