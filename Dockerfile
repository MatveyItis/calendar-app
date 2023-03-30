# Use an official Java runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the application jar file to the container
COPY build/libs/calendar-app-0.0.1-SNAPSHOT.jar ./

# Expose the port that the application will run on
EXPOSE 8080

# Start the application when the container starts
CMD ["java", "-jar", "calendar-app-0.0.1-SNAPSHOT.jar"]