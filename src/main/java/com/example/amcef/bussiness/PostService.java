package com.example.amcef.bussiness;

import com.example.amcef.bussiness.dto.CreatePostDTO;
import com.example.amcef.bussiness.model.Post;
import com.example.amcef.exception.BadRequestParams;
import com.example.amcef.exception.PostNotFound;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
@AllArgsConstructor
public class PostService {

    private RestTemplate restTemplate;


    public Post getPostFromJSonPlaceHolder(int postId){

        String url = "https://jsonplaceholder.typicode.com/posts/{id}";

        try{
            ResponseEntity<Post> responseEntity = restTemplate.getForEntity(url, Post.class, postId );

            if(responseEntity.getStatusCode() == HttpStatus.OK){
                return responseEntity.getBody();
            }
            throw new BadRequestParams("Sending Params are incorrect!");

        }catch (PostNotFound ignored){
            throw new PostNotFound("Post was not found!");
        }

    }

    public void deletePostFromJSonPlaceHolder(int postId){

    }

    public void updatePostFromJSonPlaceHolder(int postId, String body, String title){

    }

    public Post addNewPostToJSonPlaceHolder(CreatePostDTO createPostDTO){

        String url = "https://jsonplaceholder.typicode.com/posts";

        //Setup headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, Object> map = new HashMap<>();
        map.put("userId", createPostDTO.getUserId());
        map.put("title", createPostDTO.getTitle());
        map.put("body", createPostDTO.getBody());

        Post post = new Post(
                createPostDTO.getUserId(),
                createPostDTO.getTitle(),
                createPostDTO.getBody()
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        try {
            ResponseEntity<Post> responseEntity = restTemplate.postForEntity(url, post, Post.class);

            if(responseEntity.getStatusCode() == HttpStatus.CREATED){
                return responseEntity.getBody();
            }
            throw new BadRequestParams("Sending Params are incorrect!");

        }catch (PostNotFound ignored){
            throw new PostNotFound("User was not found!"); // to do exc
        }

    }

}
