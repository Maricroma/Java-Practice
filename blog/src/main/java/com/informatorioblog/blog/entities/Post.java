package com.informatorioblog.blog.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long postID;
    @Column(nullable = false)
	@NotEmpty
	@NotBlank
    private String title;
    @Column(nullable = false)
    @NotEmpty
    @NotBlank
    private String description;
    @Column(nullable = false)
    @NotEmpty
    @NotBlank
    private String body;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp postRegistrationDate;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    @OneToMany(targetEntity = com.informatorioblog.blog.entities.Comment.class, mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Comment> comments;
    @Column(nullable = false)
    @NotNull
    private Boolean published;

    @PrePersist
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public void setRegistrationDate(){
		this.postRegistrationDate = new Timestamp(new Date().getTime());
	}

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getPostRegistrationDate() {
        return postRegistrationDate;
    }

    public void setPostRegistrationDate(Timestamp postRegistrationDate) {
        this.postRegistrationDate = postRegistrationDate;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void updatePost(Post post) {
        if(post.getTitle() != null && !(post.getTitle().equals(this.title))){
			this.title = post.getTitle();
        }
        if(post.getDescription() != null && !(post.getDescription().equals(this.description))){
			this.description = post.getDescription();
        }
        if(post.getBody() != null && !(post.getBody().equals(this.body))){
			this.body = post.getBody();
		}
    }

    
}
