<h2>Dockerfile</h2>

1. download the image for mysql:
	```docker pull postgres```

2. run the MySQL server
	```docker run --name postgres-autoshop -e POSTGRES_DB=auto_project -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres```

3. create JAR file 
	```mvn clean package```

4. build application container
	```docker build -t autoshop .```

5. run container
	```docker run -d -p 8080:8080 --name autoshop --link postgres-autoshop autoshop```


<h2>docker-compose</h2>
1. run docker-compose
	```docker-compose -f docker-compose up ```