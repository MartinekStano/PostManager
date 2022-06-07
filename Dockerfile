FROM openjdk:16
EXPOSE 8080
ADD target/postmanager-docker.jar postmanager-docker.jar
ENTRYPOINT  ["java","-jar","/postmanager-docker.jar"]
