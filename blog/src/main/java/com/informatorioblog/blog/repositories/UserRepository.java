package com.informatorioblog.blog.repositories;

import java.util.Date;
import java.util.List;

import com.informatorioblog.blog.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public abstract List<User> findByCityLike(String city);  
    public abstract List<User> findByUserRegistrationDateBetween(Date userRegistrationDate, Date currentDate);
    
}
