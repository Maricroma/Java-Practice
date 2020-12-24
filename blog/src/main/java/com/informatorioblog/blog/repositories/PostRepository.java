package com.informatorioblog.blog.repositories;

import java.util.List;

import com.informatorioblog.blog.entities.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
    
    public abstract List<Post> findByTitleIgnoreCaseContaining(String title);
    public abstract List<Post> findByPublishedFalse();
}
