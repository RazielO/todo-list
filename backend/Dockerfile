# Use the official Maven image as a base image
FROM maven:3.9.6-eclipse-temurin-21-jammy AS base

# Set the working directory in the container
WORKDIR /server

# Copy the POM file to the container
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the application source code
COPY src /server/src

# Build the application
RUN mvn package -DskipTests

# Use a smaller base image for the final image
FROM eclipse-temurin:21-jre-jammy

# Set the working directory in the container
WORKDIR /server

# Copy the POM file and downloaded dependencies from the base image
COPY --from=base /server/ .

# Expose the port that the application will run on
EXPOSE 8080

# Copy the JAR file from the build image to the final image
COPY --from=base /server/target/todo*.jar app.jar

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]
