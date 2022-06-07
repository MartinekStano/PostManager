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

## Getting Started
###  Clone Project
- copy url `https://github.com/MartinekStano/PostManager.git` to your IDE.

## REST Endpoints

### 1.GET 
  - request to return specific post by `postId`
  - `/api/v1/getPost/{postId}`

 - the answer<br />
    `{`
    `"userId": "2"`<br />
    `"id:12"`<br />
    `"title": "in quibusdam tempore odit est dolorem"`<br />
    `"body": "itaque id aut magnam\npraesentium quia et ea odit et ea voluptas et\nsapiente quia nihil amet occaecati quia id voluptatem\nincidunt ea est distinctio odio"`
    `}`

### 2.POST 
  - request to return specific post by `postId`
  - `/api/v1/addNewPost`

  - pass body as JSON<br />
    `{`
    `"userId": "2"`<br />
    `"title": "in quibusdam tempore odit est dolorem"`<br />
    `"body": "itaque id aut magnam\npraesentium quia et ea odit et ea voluptas et\nsapiente quia nihil amet occaecati quia id voluptatem\nincidunt ea est distinctio odio"`
    `}`
    
    - the answer<br />
    `{`
    `"userId": "2"`<br />
    `"id:101"`<br />
    `"title": "in quibusdam tempore odit est dolorem"`<br />
    `"body": "itaque id aut magnam\npraesentium quia et ea odit et ea voluptas et\nsapiente quia nihil amet occaecati quia id voluptatem\nincidunt ea est distinctio odio"`
    `}`

### 3.PUT 
  - request to return specific post by `postId`
  - `/api/v1/updatePost/{postId}`

- pass body as JSON<br />
    `{`
    `id": "2"`<br />
    `"title": "in quibusdam tempore odit est dolorem"`<br />
    `"body": "itaque id aut magnam\npraesentium quia et ea odit et ea voluptas et\nsapiente quia nihil amet occaecati quia id voluptatem\nincidunt ea est distinctio odio"`
    `}`
    
     - the answer<br />
    `{`
    `"userId": "2"`<br />
    `"id:2"`<br />
    `"title": "in quibusdam tempore odit est dolorem"`<br />
    `"body": "itaque id aut magnam\npraesentium quia et ea odit et ea voluptas et\nsapiente quia nihil amet occaecati quia id voluptatem\nincidunt ea est distinctio odio"`
    `}`

### 4.DELETE 
  - request to return specific post by `postId`
  - `/api/v1/deletePost/{postId}`
