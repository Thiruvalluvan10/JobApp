FROM openjdk
COPY target/JobApp.jar /app/JobApp.jar
ENTRYPOINT ["java", "-jar", "/app/JobApp.jar"]
