package com.informatorioblog.blog.dto;

import com.informatorioblog.blog.entities.Post;

public class PostDTO {
    
    private Long userID;
    private Long postID;
    private Post post;

	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Long getPostID() {
		return postID;
	}
	public void setPostID(Long postID) {
		this.postID = postID;
	}

    
}