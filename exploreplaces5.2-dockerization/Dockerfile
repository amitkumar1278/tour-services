#for default profile; stanalone profile;
FROM openjdk:11
WORKDIR /
ADD target/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar //
EXPOSE 8080

# configuration to run for default db profile or standalone application
ENTRYPOINT [ "java", "-jar", "/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar"]

# configuration to run for MySQL db profile
# ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=mysql", "/exploreplaces5.2-dockerization-3.0.0-SNAPSHOT.jar"]
