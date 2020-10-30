# Second step towards dockeriazation:

In order to improve dockeriazation, We are going to Dockerize "explorePlaces" application itself with **default** db profile.

in order to run with mysql we will get error like: *"docker hikaripool-1 - exception during pool initialization"*. we need to do further changes, which we will do in next version.

in this process we will run default profile which will interact with H2 database so container of this image can run completely standalone.

As part of this we will create a docker image which include linux operating system, Java JDK 8 version 8 and the **explorePlace5.2** application jar, which include execution of below steps:


##### Step 1: first make sure that our jar of application explorePlace has been built. use below command to build.

		mvn package -DskipTests=true

check if jar file is created or not in target dir:
		
		ls target/ 

##### Step 2: we have created "Dockerfile" on root path of application, so this is sort of configuration of setting docker image.

##### check for Dockerfile

		ls
		cat Dockerfile

it will look like below:

	FROM openjdk:11
	WORKDIR /
	ADD target/explorePlaces5.2-dockerization-3.0.0-SNAPSHOT.jar //
	EXPOSE 8080
	ENTRYPOINT [ "java", "-jar", "/explorePlaces5.2-dockerization-3.0.0-SNAPSHOT.jar"]
	
So starting point is, 
we already have linux operating system from there we gona use java 11 image.
then "WORKDIR" then we are going to add jar to the image.
we are going to expose at port 8080.
Entrypoint is sort of equivalent to command line where we need to run mentioned command with actual jar file name which is within the image.

##### Step 3: Now we are going to invoke another docker command to create the image.

	docker build -t explorecali .

it will download java images, which we can check by:

	docker images	
	
We can see here "explorecali" iage with "latest" tag.
 

##### Step 4: Run the Docker container.

	docker run    --name ec-app -p8080:8080 -d explorecali

in this command:
	ec-app is the name of container.
	publishing to public host 8080 to localhost(within the container) 8080 and we are going to use explorecali image
	
	Check if container is there or started, if there will be a problem the status will be "exited" and you won't be able to see the log because image won't be running.	
	
	docker ps -a
	docker logs ec-app
	
to get details of the image, inspect it using:	
	docker inspect ex-app

##### Step 5: invoke API from postman to check if container is working fine or not.


























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


