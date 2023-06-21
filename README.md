Some example application to learn spring
To run:
# Start Application container
    - Run Dockerfile
    - docker build -t surferdocker:1 .
    - docker run -d --name surferdocker -p 8080:8080 surferdocker:1 
# Start MariaDb container
    - docker run --detach --name mariaDbSurfer -p 3306:3306 --env MARIADB_USER=test --env MARIADB_PASSWORD=test --env MARIADB_ROOT_PASSWORD=root  mariadb:latest   
    - docker exec -it mariaDbSurfer bash
    - mysql -u root -p
    - GRANT ALL PRIVILEGES ON *.* TO 'test'@'%' IDENTIFIED BY 'test';
# Some API Calls
    - curl -XPOST "localhost:8080/surfer" -H "Content-Type: application/json" -d "{\"name\" : \"leon\", \"country\" : \"swiss\", \"gender\" : \"f\"}"
    - curl -XPOST "localhost:8080/surfer" -H "Content-Type: application/json" -d "{\"name\" : \"michele\", \"country\" : \"italian\", \"gender\" : \"m\"}"
    - curl -XPOST "localhost:8080/contest?place=lucerne&nrOfSurfer=5"
    - curl -XPOST "localhost:8080/1/3/register"
    - curl -XGET "localhost:8080/3/contest"
    - curl -XGET "localhost:8080/1/surfer"
    - curl -XGET "localhost:8080/maleSurfers"
    - curl -XGET "localhost:8080/maleSurfersSql"