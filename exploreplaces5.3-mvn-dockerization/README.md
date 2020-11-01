# Extending, Securing and Dockerizing Spring Boot Microservices

We are working on this application to make it production ready, In order to do that we are doing dockerization of application:

# First step towards dockerization

Below things were implemented in first version of dockerization **exploreplaces** service:
-	Final version of Product integrated with External MySql Database along with Docker.
-	Install Docker For Mac/Windows/Linux
- 	Integrated with flywaydb to manage duplication of initialiation Schema and data.
-	DB profile to use H2 and MySQL database

-----------------------------------

# Second step towards dockeriazation:

In order to improve dockeriazation, We are going to Dockerize "exploreplaces" application itself.

in this process we will run default profile which will interact with H2 database so container of this image can run completely standalone.

currently it will not run with mysql and throw exception like: *"docker hikaripool-1 - exception during pool initialization"*. we need to do further changes, which we will do in next version.

As part of this we will create a docker image which include Linux operating system, Java JDK 11 and the **explorePlace5.2** application jar.

following steps need to perform for dockerization of standalone application.

- first make sure that our jar of application explorePlace has been built and placed inside "/target" dir.
- we need to create "Dockerfile" on root path of application, so this is sort of configuration of setting docker image.
- Now we need to invoke another docker command to create the image. which will download java images, if not available in local.
- Run the Docker container using docker command. if the status is "exited" then there is some issue in running the image. to get details of the image we can inspect as well.
- invoke API from postman to check if container is working fine or not.

-----------------------------------

# Third step towards dockeriazation:

if we want to run the same application with MySQL we need to do few changes in above explained standalone application steps:
- need to define active profile in Dockerfile configuration as below:
	
	ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=mysql", "/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar"]
	
- need to pass a complete DB URI(container name instead localhost) for connectivity, which we need to define in *application-mysql.properties* like:
	
	spring.datasource.url=jdbc:mysql://ec-mysql:3306/exploreplaces
	
- we need to link DB container to MY sql like belows:
	
	docker run --name ec-app -p 8080:8080 --link ec-mysql:mysql -d exploreplaces
	
-----------------------------------

# Fourth step towards dockeriazation:

In this step we will pass DB details from commandline also copying migration script to docker container from local.

for this we created a seperate db profile "application-docker.properties" containing spring expression language and for this we can substitute parameters from command line environment variable.
 
 Also updated Entrypoint in Dockerfile and pass all input from docker run command.
 
 -----------------------------------

# Fifth step towards dockeriazation:

In this we try to create docker image through maven for that we configure spotify plugin in pom.xml.

we have different command explain in readme.md docs to build different images dynamicallly at the same time and deploy on different port from cmd.

this is not fully working, we need to do some enhancement.


-----------------------------------

#### Setup

-	Set JAVA_HOME
-	Set M2_HOME
-	Add M2_HOME/bin to the execution path
-	mvn package -DskipTests

------------------------------------

### Docker Commands
##### Start MySql Container (downloads image if not found)
	
	docker run  --detach   --name ec-mysql -p 6604:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=exploreplaces -e MYSQL_USER=admin -e MYSQL_PASSWORD=password123 -d mysql
	

##### view all images
	
	docker images
	

##### view all containers (running or not)
	
	docker ps -a
	
##### Interact with Database (link to ec-mysql container) with mysql client
	
	docker run -it --link ec-mysql:mysql --rm mysql sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'
	
##### Stop ec-mysql container
	
	docker stop ec-mysql
	
##### (ReStart) ec-mysql container
	
	docker start ec-mysql
	
##### Remove ec-mysql container (must stop it first)
	
	docker rm ec-mysql
	
##### Remove image (must stop and remove container first)
	
	docker rmi mysql:latest
	
------------------------------------


#### Startup with Profile settings
##### Default profile, H2 database

	mvn spring-boot:run 
	or
	java  -jar target/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar


##### mysql profile, MySql database (requires running docker container ec-mysql)
changing active profile from CMD, (first go to project directory):


	mvn spring-boot:run -Dspring.profiles.active=mysql 
	or
	mvn spring-boot:run -Dspring.profiles.active=mysql -DskipTests=true	
	or
	java  -Dspring.profiles.active=mysql -jar target/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar

------------------------------------
	

#### Dockerize Explore Places

##### Build jar, image, set default profile

	mvn package -DskipTests docker:build 

###### container with default property set in Dockerfile

	docker run --name ec-app-default -p 8080:8080  -d exploreplaces-default


------------------------------------

##### Build jar, image, set mysql profile

	mvn package -DskipTests docker:build -Dec-profile=mysql

##### Run Docker container with mysql profile

	docker run --name ec-app-mysql -p 8181:8080  --link ec-mysql:mysql -d exploreplaces-mysql


------------------------------------


##### Build jar, image, set docker profile

	mvn package -DskipTests docker:build -Dec-profile=docker

##### Run Docker container with docker profile set in Dockerfile and migration scripts on host

	docker run --name ec-app-docker -p 8282:8080 -v ~/home/amit/db/migration:/var/migration -e server=ec-mysql -e port=3306 -e dbuser=admin -e dbpassword=password123 --link ec-mysql:mysql -d exploreplaces-docker


------------------------------------


##### Enter Docker container

docker exec -t -i ec-app /bin/bash

#####

------------------------------------

##### Push image to Docker hub
######Login to Docker hub locally
	docker login
	
###### Upload image

	docker tag <image id> <docker hub repository>/exploreplaces-default:latest

###### Download image

	docker pull <docker hub repository>/exploreplaces-default

##### Run Container from docker hub image

	docker run --name ec-app-default -p 8080:8080  -d <docker hub repository>/exploreplaces-default

------------------------------------
# frequesnt used docker commands

	docker ps -a
	docker images
	docker rmi exploreplaces
	



















