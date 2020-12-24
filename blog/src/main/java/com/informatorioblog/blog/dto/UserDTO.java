package com.informatorioblog.blog.dto;

import com.informatorioblog.blog.entities.User;

public class UserDTO {
     
    private Long userID;
    private User user;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
