package com.informatorioblog.blog.services;

import java.util.List;

import com.informatorioblog.blog.entities.Comment;
import com.informatorioblog.blog.repositories.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment editComment(Comment comment, Long id) {
        
	    Comment editedComment = commentRepository.getOne(id);
	    editedComment.updateComment(comment);
	    return commentRepository.save(editedComment);
       
    }

    public boolean deleteComment(Long id) {
        
        commentRepository.deleteById(id);
        return true;
    }

    public List<Comment> getComments(Long id, Integer number){
        return commentRepository.findCommentsOfPost(id, number);
    }

    public Comment getComment(Long id) {
        return commentRepository.getOne(id);
    }
}
