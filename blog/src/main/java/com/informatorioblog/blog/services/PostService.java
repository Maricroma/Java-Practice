package com.informatorioblog.blog.services;

import java.util.List;

import com.informatorioblog.blog.entities.Post;
import com.informatorioblog.blog.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post editPost(Post post, Long id) {
        Post editedPost = postRepository.getOne(id);
        editedPost.updatePost(post);
        return postRepository.save(editedPost);
        
    }

    public boolean deletePost(Long id) {
	   postRepository.deleteById(id);
	   return true;
        
    }

    public List<Post> getPostByTitle(String title){
        return postRepository.findByTitleIgnoreCaseContaining(title);
    }

    public List<Post> getPostByNotPublished(){
        return postRepository.findByPublishedFalse();
    }

    public Post getPost(Long id) {
        return postRepository.getOne(id);
    }


}
