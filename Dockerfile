FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY target/Crud-0.0.1-SNAPSHOT.jar app.jar

RUN apt-get install maven -y
RUN mvn clean install

