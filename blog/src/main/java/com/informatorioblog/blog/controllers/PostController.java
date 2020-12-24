package com.informatorioblog.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import com.informatorioblog.blog.dto.PostDTO;
import com.informatorioblog.blog.entities.Post;
import com.informatorioblog.blog.entities.User;
import com.informatorioblog.blog.services.PostService;
import com.informatorioblog.blog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;
    
    @GetMapping
    public ResponseEntity<?> getPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDTO postDTO) {
        User user = userService.getUser(postDTO.getUserID());
        Post post = postDTO.getPost();
        post.setUser(user);
        postService.createPost(post);
        return new ResponseEntity<> ("Se ha creado una publicación.", HttpStatus.CREATED);
        
    }

    @PutMapping("/")
    public ResponseEntity<?> editPost(@Valid @RequestBody PostDTO postDTO){
        Post post = postDTO.getPost();
        postService.editPost(post, postDTO.getPostID());
        return new ResponseEntity<> ("Publicación actualizada.", HttpStatus.OK);
        
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deletePost(@RequestBody PostDTO postDTO ){
        postService.deletePost(postDTO.getPostID());
        return new ResponseEntity<> ("Publicación eliminada.", HttpStatus.OK);
        
    }

    @GetMapping( path = "/{title}")
    public ResponseEntity<?> getPostByTitle(@PathVariable("title") String title) {
        List<Post> posts = postService.getPostByTitle(title); 
        return new ResponseEntity<> (posts, HttpStatus.OK);

    }

    @GetMapping( path = "/not_published")
    public ResponseEntity<?> getPostByNotPublished() {
        List<Post> posts = postService.getPostByNotPublished(); 
        return new ResponseEntity<> (posts, HttpStatus.OK);
    }


}
