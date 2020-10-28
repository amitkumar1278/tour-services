# Extending, Securing and Dockerizing Spring Boot Microservices

We are working on this application to make it production ready, In order to do that Final version of Product requires External MySql Database. 

For this we can install MySQl externally and connect it with connection string but here we will try to install MySQL on docker and connect to the application. 

##1. Install Docker For Mac/Windows/Linux
install docker in your local system or server for that follow below steps.

For Ubuntu follow steps mention in link: 
		
	https://docs.docker.com/engine/install/ubuntu/

For more examples and ideas, visit:
	
	https://docs.docker.com/get-started/


##2. Docker post-installation steps for Linux

This section contains optional procedures for configuring Linux hosts to work better with Docker.

##### Manage Docker as a non-root user
The Docker daemon binds to a Unix socket instead of a TCP port. By default that Unix socket is owned by the user root and other users can only access it using sudo. The Docker daemon always runs as the root user.

If you don’t want to preface the docker command with sudo, create a Unix group called docker and add users to it. When the Docker daemon starts, it creates a Unix socket accessible by members of the docker group.

for details follow below URL:

		https://docs.docker.com/engine/install/linux-postinstall/	




##3. Docker Commands
##### Start MySql Container (downloads image if not found)
``
docker run  --detach   --name ec-mysql -p 6604:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=explorecali -e MYSQL_USER=cali_user -e MYSQL_PASSWORD=cali_pass -d mysql
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