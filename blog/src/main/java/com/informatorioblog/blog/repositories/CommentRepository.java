package com.informatorioblog.blog.repositories;

import java.util.List;

import com.informatorioblog.blog.entities.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{
    
    @Query(value = "SELECT * FROM comment WHERE post_id = ? ORDER BY comment_registration_date DESC LIMIT ?", nativeQuery = true)
    public abstract List<Comment> findCommentsOfPost(Long id, Integer number);
}
