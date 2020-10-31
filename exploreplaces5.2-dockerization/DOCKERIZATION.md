# Second step towards dockeriazation:

In order to improve dockeriazation, We are going to Dockerize "exploreplaces" application itself with **default** db profile.




# Docker Flow

Once docker is running next step can be stop and commit.

The Docker flow:
- Image (docker run: it takes image to container)
- Running Container
- Stopped Container(it's stopped but not deleted.)
- New Image (docker commit: it takes container to new image.)

Here we will explore, How we can create Image from the container.

look at the most recently existed container:
	docker ps

to see all container 
	docker ps -a

to see last container 
	docker ps -l --format=$FORMAT

to start with new Ubuntu Image(It will download ubuntu image if not available in local):
	docker run -ti ubuntu bash

take a look, its totally blank; normal ubuntu container.:
	ls

make a file:
	touch MY-IMPORTANT-FILE

exit from ubuntu container.
	exit
	
look into most recently existed container:
	docker ps -l --format=$FORMAT

create new image of recent container:
	dcoker commit {containerID}

tag image with a name:
	
	docker tag {big image id} my-image
	docker images
	docker run -ti my-image bash

tag image while commiting
	docker commit current_image my-image-2
-----------------------------------

# Dockeriation of Application


# Standalone & MySQL Application dockeriation

process to run default db profile and mysql profile is almost same.

in case of **Standalone application**, we will run default profile which will interact with H2 database so container of this image can run completely standalone.

in case of **MySQL DB profile**, we did little changes in *Dockerfile* and *application-mysql.properties* which is like:
 **Dockerfile*:* ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=mysql", "/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar"]
 **application-mysql.properties**: spring.datasource.url=jdbc:mysql://ec-mysql:3306/exploreplaces


As part of this we will create a docker image which include linux operating system, Java JDK 8 version 8 and the **explorePlace5.2** application jar, which include execution of below steps:

-----------------------------------
##### Step 1: first make sure that our jar of application explorePlace has been built. use below command to build.

		mvn package -DskipTests
		OR
		mvn package -DskipTests=true

check if jar file is created or not in target dir:
		
		ls target/ 

-----------------------------------
##### Step 2: we have created "Dockerfile" on root path of application, so this is sort of configuration of setting docker image.

##### check for Dockerfile

		ls
		cat Dockerfile

it will look like below:

	FROM openjdk:11
	WORKDIR /
	ADD target/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar //
	EXPOSE 8080
	ENTRYPOINT [ "java", "-jar", "/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar"]
	
So starting point is, 
we already have linux operating system from there we gona use java 11 image.
then "WORKDIR" then we are going to add jar to the image.
we are going to expose at port 8080.
Entrypoint is sort of equivalent to command line where we need to run mentioned command with actual jar file name which is within the image.


-----------------------------------
##### Step 3: Now we are going to invoke another docker command to create the image.

	docker build -t exploreplaces .

it will download java images, which we can check by:

	docker images	
	
We can see here "exploreplaces" image with "latest" tag.
 

-----------------------------------
##### Step 4: Run the Docker container.


**Run Docker container with default property set in Dockerfile :** 
`` docker run --name ec-app -d explorecali ``

**Run Docker container with h2 or default db profile :** 
``docker run --name ec-app -p8080:8080 -d exploreplaces``

**Run Docker container with mysql profile set in Dockerfile :** 
`` docker run --name ec-app -p 8080:8080 --link ec-mysql:mysql -d exploreplaces ``


**Run Docker container with docker profile set in Dockerfile and migration scripts on host :** 
`` docker run --name ec-app -p 8080:8080 -v ~/db/migration:/var/migration -e server=ec-mysql -e port=3306 -e dbuser=cali_user -e dbpassword=cali_pass --link ec-mysql:mysql -d explorecali ``


in this command:
	ec-app is the name of container.
	publishing to public host 8080 to localhost(within the container) 8080 and we are going to use exploreplaces image
	
	Check if container is there or started, if there will be a problem the status will be "exited" and you won't be able to see the log because image won't be running.	
	
to see all container	
	docker ps -a
	
to see last container
	docker ps -l
	docker ps -l --format=$FORMAT
	
	docker logs ec-app
	
to get details of the image, inspect it using:	
	docker inspect ex-app


-----------------------------------
##### Step 5: enter Docker container
	
	``
	docker exec -t -i ec-app /bin/bash
	``
	
-----------------------------------	
##### Step 6: invoke API from postman to check if container is working fine or not.








# Application dockeriation with MySQL



in order to run with mysql we will get error like: *"docker hikaripool-1 - exception during pool initialization"*. we need to do further changes, which we will do in next part.

















Sample Postman json data of Explore Place  Service API call:



// sample
1. http://localhost:8080/tours/12345/ratings

Request Body:

httpMethod: POST
Body -> Raw -> JSON(application/json) 
{
	"score": 6,
	"comment": "It was great !",
	"customerId": 1233
}

Response Body:
Status: 200 OK
"Tour does not exist :12345" 


