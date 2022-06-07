package com.example.amcef.presentation;

import com.example.amcef.bussiness.service.PostService;
import com.example.amcef.bussiness.dto.CreatePostDTO;
import com.example.amcef.bussiness.dto.PutPostDTO;
import com.example.amcef.bussiness.model.Post;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(path = "/api/v1/getPost/{postId}")
    public Post getPost(@PathVariable("postId") int postId){
        return postService.getPostFromJSonPlaceHolder(postId);
    }

    @DeleteMapping(path = "/api/v1/deletePost/{postId}")
    public void deletePost(@PathVariable("postId") int postId){
        postService.deletePostFromJSonPlaceHolder(postId);
    }

    @PostMapping(path = "/api/v1/addNewPost")
    public Post addNewPost(@RequestBody CreatePostDTO createPostDTO){
        return postService.addNewPostToJSonPlaceHolder(createPostDTO);
    }

    @PutMapping(path = "/api/v1/updatePost/{postId}")
    public Post updatePost(
            @PathVariable("postId") int postId,
            @RequestBody PutPostDTO putPostDTO) {
         return postService.updatePostFromJSonPlaceHolder(postId, putPostDTO.getTitle(), putPostDTO.getBody());
    }

}
