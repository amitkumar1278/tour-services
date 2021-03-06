# MySQL & Docker integration in Spring Boot Microservices


## For MySQL integration we have two option:
	1. We can install MySQl externally and connect it with connection string.
	2. We can install MySQL on docker and connect to the application. 


## Advice for running Application with MySQL	
	
- Installed and configure Docker by following **Step 1 & 2**
- Once Docker installation is done follow **Step 3** and install mysql and create database with credentials.
- Once MySQL is ready, connect using command mention in **Step 3**, if you are getting access related issue add sudo.
- follow **Step 4** to verify db and tables.
- Data will persist even application is stopped. 
- In current implementation of application, if we start application for 2nd time duplicate record will inserted with different id. 
	"schema.sql" and "data.sql" are good for initialization but not migration.
- to overcome initialization issue we integrate with **flywaydb** and create version of schema and data which is handle in separate db by flywaydb.
- to remove/stop docker container follow command mentioned in **Step 3**.


## Step 1. Install Docker For Mac/Windows/Linux
install docker in your local system or server for that follow below steps.

For Ubuntu follow steps mention in link: 
		
	https://docs.docker.com/engine/install/ubuntu/

For more examples and ideas, visit:
	
	https://docs.docker.com/get-started/


## Step 2. Docker post-installation steps for Linux

This section contains optional procedures for configuring Linux hosts to work better with Docker.

##### Manage Docker as a non-root user
The Docker daemon binds to a Unix socket instead of a TCP port. By default that Unix socket is owned by the user root and other users can only access it using sudo. The Docker daemon always runs as the root user.

If you don’t want to preface the docker command with sudo, create a Unix group called docker and add users to it. When the Docker daemon starts, it creates a Unix socket accessible by members of the docker group.

for details follow below URL:

		https://docs.docker.com/engine/install/linux-postinstall/	




## Step 3. Docker Commands for MySQL
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

use sudo if you are getting connection error.

refer below link if not able to connect with IP address: 
	https://www.tecmint.com/fix-error-2003-hy000-cant-connect-to-mysql-server-on-127-0-0-1-111/


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

## Step 4. MySQL commands once connection is established.

	``	mysql> show databases;
		mysql> use exploreplaces;
		mysql> show tables;
		mysql> select * from tour;
		mysql> quit
	``
