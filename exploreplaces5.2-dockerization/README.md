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
	*ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=mysql", "/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar"]*
- need to pass a complete DB URI(container name instead localhost) for connectivity, which we need to define in *application-mysql.properties* like:
	*spring.datasource.url=jdbc:mysql://ec-mysql:3306/exploreplaces*
- we need to link DB container to MY sql like belows:
	*docker run --name ec-app -p 8080:8080 --link ec-mysql:mysql -d explorecali*

-----------------------------------

# Fourth step towards dockeriazation:



#### Setup

-	Set JAVA_HOME
-	Set M2_HOME
-	Add M2_HOME/bin to the execution path
-	mvn package -DskipTests


### Docker Commands
##### Start MySql Container (downloads image if not found)
	``
	docker run  --detach   --name ec-mysql -p 6604:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=exploreplaces -e MYSQL_USER=admin -e MYSQL_PASSWORD=password123 -d mysql
	``

##### view all images
	``
	docker images
	``

##### view all containers (running or not)
	``
	docker ps -a
	``
##### Interact with Database (link to ec-mysql container) with mysql client
	``
	docker run -it --link ec-mysql:mysql --rm mysql sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'
	``
##### Stop ec-mysql container
	``
	docker stop ec-mysql
	``
##### (ReStart) ec-mysql container
	``
	docker start ec-mysql
	``
##### Remove ec-mysql container (must stop it first)
	``
	docker rm ec-mysql
	``
##### Remove image (must stop and remove container first)
	``
	docker rmi mysql:latest
	``


#### Startup with Profile settings
##### Default profile, H2 database

	``	mvn spring-boot:run ``
or

	``java  -jar target/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar``


##### mysql profile, MySql database (requires running docker container ec-mysql)
changing active profile from CMD, (first go to project directory):


	``mvn spring-boot:run -Dspring.profiles.active=mysql 
	or
	mvn spring-boot:run -Dspring.profiles.active=mysql -DskipTests=true	``

or

	``java  -Dspring.profiles.active=mysql -jar target/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar``
	

#### Dockerize Explore California

**Build jar** 	``mvn package -DskipTests``

**Build Docker image**	``docker build -t exploreplaces . ``

------------------------------------
**Run Docker container with default property set in Dockerfile :** 
`` docker run --name ec-app -d explorecali ``

**Run Docker container with h2 or default db profile :** 
``docker run --name ec-app -p8080:8080 -d exploreplaces``

**Run Docker container with mysql profile set in Dockerfile :** 
`` docker run --name ec-app -p 8080:8080 --link ec-mysql:mysql -d exploreplaces ``


**Run Docker container with docker profile set in Dockerfile and migration scripts on host :** 
`` docker run --name ec-app -p 8080:8080 -v ~/db/migration:/var/migration -e server=ec-mysql -e port=3306 -e dbuser=cali_user -e dbpassword=cali_pass --link ec-mysql:mysql -d explorecali ``

---------------------------------------------	

**enter Docker container**	``docker exec -t -i ec-app /bin/bash``
	


# frequesnt used docker commands

	docker ps -a
	docker images
	docker rmi exploreplaces
	docker images
	



















