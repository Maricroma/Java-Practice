package com.informatorioblog.blog.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Comment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long commentID;
    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
    @JsonIgnore
    @JoinColumn(name = "post_id", nullable = false)
    @ManyToOne
    private Post post;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp commentRegistrationDate;
    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    @Size(min = 4, max = 200)
    private String commentBody;

    @PrePersist
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public void setRegistrationDate(){
		this.commentRegistrationDate = new Timestamp(new Date().getTime());
	}

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public Timestamp getCommentRegistrationDate() {
        return commentRegistrationDate;
    }

    public void setCommentRegistrationDate(Timestamp commentRegistrationDate) {
        this.commentRegistrationDate = commentRegistrationDate;
    }

    public String getComment() {
        return commentBody;
    }

    public void setComment(String commentBody) {
        this.commentBody = commentBody;
    }

    public void updateComment(Comment comment) {
        if(comment.getComment() != null && !(getComment().equals(this.commentBody))){
			this.commentBody = comment.getComment();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

  
}
