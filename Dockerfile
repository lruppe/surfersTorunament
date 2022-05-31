# docker build -t surferdocker:1 .
# docker run -d --name surferdocker -p 8080:8080 surferdocker:1
FROM openjdk:18
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]