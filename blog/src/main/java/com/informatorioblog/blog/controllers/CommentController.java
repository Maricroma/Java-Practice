package com.informatorioblog.blog.controllers;

import java.util.List;

import com.informatorioblog.blog.dto.CommentDTO;
import com.informatorioblog.blog.entities.Comment;
import com.informatorioblog.blog.entities.Post;
import com.informatorioblog.blog.entities.User;
import com.informatorioblog.blog.services.CommentService;
import com.informatorioblog.blog.services.PostService;
import com.informatorioblog.blog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @PostMapping("/")
    public ResponseEntity<?> createComment(@RequestBody CommentDTO commentDTO) {
        Post post = postService.getPost(commentDTO.getPostID());
        User user = userService.getUser(commentDTO.getUserID());
        Comment comment = commentDTO.getComment();
        comment.setUser(user);
        comment.setPost(post);
        commentService.createComment(comment);
        return new ResponseEntity<> ("El comentario se ha guardado.", HttpStatus.CREATED);
       
    }

    @PutMapping("/")
    public ResponseEntity<?> editComment(@RequestBody CommentDTO commentDTO){
        Comment comment = commentService.getComment(commentDTO.getCommentID());
        comment.setComment(commentDTO.getComment().getComment());
        commentService.editComment(comment, commentDTO.getCommentID());
        return new ResponseEntity<> ("Comentario actualizado.", HttpStatus.OK);
        
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteComment(@RequestBody CommentDTO commentDTO){
        commentService.deleteComment(commentDTO.getCommentID());
        return new ResponseEntity<> ("Comentario eliminado.", HttpStatus.OK);
        
    }

    @GetMapping("/post_{id}/number_{number}")
    public List<Comment> getCommentById(@PathVariable("id") Long id, @PathVariable("number") Integer number) {
        return this.commentService.getComments(id, number);
    }


}
