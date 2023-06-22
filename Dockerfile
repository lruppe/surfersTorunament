# Application Container
# docker build -t surferdocker:1 .
# docker run -d --name surferdocker -p 8080:8080 surferdocker:1

# DB Container
# docker run --detach --name mariaDbSurfer -p 3306:3306 --env MARIADB_USER=test --env MARIADB_PASSWORD=test --env MARIADB_ROOT_PASSWORD=root mariadb:latest
# docker exec -it some-mariadb bash
# docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mariaDbSurfer
# mysql -u root -p
# GRANT ALL PRIVILEGES ON *.* TO 'test'@'%' IDENTIFIED BY 'test';

FROM openjdk:18
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]