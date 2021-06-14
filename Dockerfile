#Instalación de gradle
#FROM gradle:4.7.0-jdk8-alpine AS build
#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle build
FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY microservicio/build/libs/*.jar home/spring/application.jar
MAINTAINER hugojose14
EXPOSE 8083
#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=microservicio/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/home/spring/application.jar"]
#FROM openjdk:8-jdk-alpine
#EXPOSE 8083
#ARG JAR_FILE=microservicio/build/libs/*.jar
#ADD ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]


