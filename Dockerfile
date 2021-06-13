FROM openjdk:8-jdk-alpine
MAINTAINER hugo perez
EXPOSE 8083
# valor por defecto del jar
ARG JAR_FILE = microservicio/build/libs/*.jar
COPY ${JAR_FILE}  app.jar
ENTRYPOINT ["java","-jar","/consignaciones.jar"]