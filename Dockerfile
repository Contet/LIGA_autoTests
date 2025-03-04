FROM openjdk:21-jdk
WORKDIR /app
COPY . Tests-1.jar /app/test.jar
ENTRYPOINT ["java", "-jar", "test.jar"]
CMD ["mvn", "test"]