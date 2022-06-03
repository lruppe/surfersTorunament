Some example application to learn spring
To run:
# Start Application container
    - Run Dockerfile
    - docker build -t surferdocker:1 .
    - docker run -d --name surferdocker -p 8080:8080 surferdocker:1 
# Start MariaDb container
    - docker run --detach --name some-mariadb -p 3306:3306 --env MARIADB_USER=example-user --env MARIADB_PASSWORD=my_cool_secret --env MARIADB_ROOT_PASSWORD=my-secret-pw  mariadb:latest
    - docker exec -it some-mariadb bash
    - mysql -u root -p
    - GRANT ALL PRIVILEGES ON *.* TO 'example-user'@'%' IDENTIFIED BY 'my_cool_secret';
# Some API Calls
    - curl -XPOST "localhost:8080/surfer" -H "Content-Type: application/json" -d "{\"name\" : \"leon\", \"country\" : \"swiss\", \"gender\" : \"f\"}"
    - curl -XPOST "localhost:8080/surfer" -H "Content-Type: application/json" -d "{\"name\" : \"michele\", \"country\" : \"italian\", \"gender\" : \"m\"}"
    - curl -XPOST "localhost:8080/contest?place=lucerne&nrOfSurfer=5"
    - curl -XPOST "localhost:8080/1/3/register"
    - curl -XGET "localhost:8080/3/contest"
    - curl -XGET "localhost:8080/1/surfer"
    - curl -XGET "localhost:8080/maleSurfers"