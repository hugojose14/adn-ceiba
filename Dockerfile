FROM openjdk:8
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY ./microservicio/build/libs/*.jar ./app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]