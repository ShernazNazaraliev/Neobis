<h2>Dockerfile</h2>

1. download the image for mysql:
	```docker pull mysql:8.0```

2. run the MySQL server
	```docker run --name mysql-autoshop -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=autoshop -e MYSQL_ROOT_PASSWORD=password -e MYSQL_PASSWORD=password -d mysql:8.0```

3. create JAR file 
	```mvn clean package```

4. build application container
	```docker build -t autoshop .```

5. run container
	```docker run -d -p 9090:9090 --name autoshop --link mysql-autoshop autoshop ```


<h2>docker-compose</h2>
1. run docker-compose
	```docker-compose -f docker-compose.yml up ```