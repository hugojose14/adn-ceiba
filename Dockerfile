FROM openjdk:8-jdk-alpine
MAINTAINER hugojose14
EXPOSE 8083
ARG JAR_FILE=microservicio/build/libs/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]