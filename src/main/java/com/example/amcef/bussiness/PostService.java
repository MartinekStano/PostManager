package com.example.amcef.bussiness;

import com.example.amcef.bussiness.dto.CreatePostDTO;
import com.example.amcef.bussiness.model.Post;
import com.example.amcef.bussiness.model.User;
import com.example.amcef.exception.BadRequestParams;
import com.example.amcef.exception.PostNotFound;
import com.example.amcef.exception.UserNotFound;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
@AllArgsConstructor
public class PostService {

    private RestTemplate restTemplate;


    public Post getPostFromJSonPlaceHolder(int postId){

        String urlForPost = "https://jsonplaceholder.typicode.com/posts/{id}";

        try{
            ResponseEntity<Post> responseEntity = restTemplate.getForEntity(urlForPost, Post.class, postId );

            if(responseEntity.getStatusCode() == HttpStatus.OK){
                return responseEntity.getBody();
            }
            return null;

        }catch (HttpStatusCodeException ex){
            if(ex.getRawStatusCode() == 400) {
                throw new BadRequestParams("Something went wrong");
            }
            else {
                throw new PostNotFound("Post was not found");
            }
        }

    }

    public void deletePostFromJSonPlaceHolder(int postId){

        String urlForPost = "https://jsonplaceholder.typicode.com/posts/{id}";

        try {
            restTemplate.delete(urlForPost, postId);
        }catch (HttpStatusCodeException ignored){
            throw new BadRequestParams("Something went wrong");
        }
    }

    public Post updatePostFromJSonPlaceHolder(int postId, String title, String body){

        String urlForPost = "https://jsonplaceholder.typicode.com/posts/{id}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Post post = new Post(postId, title, body);
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);

        try {
            ResponseEntity<Post> responseEntity = restTemplate.exchange(urlForPost, HttpMethod.PUT, entity, Post.class, postId);

            if(responseEntity.getStatusCode() == HttpStatus.OK){
                return getPostFromJSonPlaceHolder(postId);
            }
            //throw new BadRequestParams("Something went wrong");
            return null;
        }catch (HttpStatusCodeException ex){
            if(ex.getRawStatusCode() == 400) {
                throw new BadRequestParams("Something went wrong");
            }
            else {
                throw new PostNotFound("Post was not found");
            }

        }

    }

    public Post addNewPostToJSonPlaceHolder(CreatePostDTO createPostDTO){

        String urlForPost = "https://jsonplaceholder.typicode.com/posts";
        String urlForUser = "https://jsonplaceholder.typicode.com/users/{id}";

        //Setup headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, Object> map = new HashMap<>();
        map.put("userId", createPostDTO.getUserId());
        map.put("title", createPostDTO.getTitle());
        map.put("body", createPostDTO.getBody());

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);


        try {
            ResponseEntity<User> responseUser = restTemplate.getForEntity(urlForUser, User.class, createPostDTO.getUserId());

            if (responseUser.getStatusCode() == HttpStatus.OK){

                ResponseEntity<Post> responseEntity = restTemplate.postForEntity(urlForPost, entity, Post.class);
                if (responseEntity.getStatusCode() == HttpStatus.CREATED){
                    return responseEntity.getBody();
                }
                return null;
            }
            return null;

        }catch (HttpStatusCodeException ex){
            if(ex.getRawStatusCode() == 400) {
                throw new BadRequestParams("Something went wrong");
            }
            else {
                throw new PostNotFound("Post was not found");
            }
        }

    }

}
