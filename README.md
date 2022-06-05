# Post Manager

## About The Project
Post manager is used to manage posts. We can view posts by `postId`, add new posts, edit existing posts and delete posts by `postId`. When a post is added, it is checked for existence on the `userId` base.

- Treatment of exceptions
- Project scalability 
- Pre-prepared endpoints

## Built With

Project was built with framework
- SpringBoot

Endpoints were tested using 
- Postman

##Getting Started
###To Run Using Docker File

1. `cd/<local_directory>/postmanager`
2.  `mvn clean package`
3.  Build The Docker Image: `docker build -t postmanager-docker.`
4.  Run The Spring Boot Application: `docker run -p 8080:8080 postmanager-docker`

##REST Endpoints

#1.GET 
  - request to return specific post by `postId`
  - `/api/v1/getPost/{postId}`

#2.POST 
  - request to return specific post by `postId`
  - `/api/v1/addNewPost`

#3.PUT 
  - request to return specific post by `postId`
  - `/api/v1/updatePost/{postId}`

#4.DELETE 
  - request to return specific post by `postId`
  - `/api/v1/deletePost/{postId}`
