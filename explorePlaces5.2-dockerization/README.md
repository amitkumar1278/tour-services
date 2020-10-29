# Extending, Securing and Dockerizing Spring Boot Microservices

We are working on this application to make it production ready, In order to do that following technology we are planning integrat:

-	Final version of Product integrated with External MySql Database along with Docker.
-	Install Docker For Mac/Windows/Linux
- 	Integrated with flywaydb to manage duplication of initialiation Schema and data.
-	DB profile to use H2 and MySQL database


#### Setup

-	Set JAVA_HOME
-	Set M2_HOME
-	Add M2_HOME/bin to the execution path
-	mvn package -DskipTests


#### Startup with Profile settings
##### Default profile, H2 database

we can change spring profile simply by chnaging below value in application.properties file:

	for default profile:	spring.profiles.active=default
	for mysql profile:	spring.profiles.active=mysql


**Start Spring boot application from CMD**

	``
	mvn -version
	mvn spring-boot:run
	``
or

	``
	java  -jar target/explorecali-3.0.0-SNAPSHOT.jar
	``


##### mysql profile, MySql database (requires running docker container ec-mysql)
changing active profile from CMD, (first go to project directory):


	``
	mvn spring-boot:run -Dspring.profiles.active=mysql 
	or
	mvn spring-boot:run -Dspring.profiles.active=mysql -DskipTests=true
	``

or

	``
	java  -Dspring.profiles.active=mysql -jar target/explorecali-3.0.0-SNAPSHOT.jar
	``
	

#### Dockerize Explore California

##### Build jar
``
mvn package -DskipTests
or
mvn package -DskipTests=true


``
# check if jar file is build or not
ls tafrget/  

# chceck for Dockerfile
ls
cat Dockerfile

##### Build Docker image
``
docker build -t explorecali .

# check all images
docker images
``
##### Run Docker container
``
docker run    --name ec-app -p8080:8080 -d explorecali

docker ps -a

docker logs ec-app

docker inspect ex-app
 
``
##### enter Docker container
``
docker exec -t -i ec-app /bin/bash
``


# Link the Java application and database Docker containers

docker ps -a
docker images
docker rmi explorecali
docker images
# docker file updated; change the profile setting




















