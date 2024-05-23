FROM ubuntu:latest AS build
FROM amazoncorretto:17-alpine-jdk
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY target/Crud-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
RUN apt-get install maven -y
RUN mvn clean install

