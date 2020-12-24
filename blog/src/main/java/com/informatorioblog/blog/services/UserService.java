package com.informatorioblog.blog.services;

import java.util.Date;
import java.util.List;

import com.informatorioblog.blog.entities.User;
import com.informatorioblog.blog.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
    	userRepository.deleteById(id);   
    }

    public User editUser(User user, Long id) {
    	User editedUser = userRepository.getOne(id);
        editedUser.updateUser(user);
        return userRepository.save(editedUser);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> getUserByCity(String city){
        return userRepository.findByCityLike(city);
    }

    public List<User> getUserByRegistrationDate(Date userRegistrationDate, Date currentDate){
        return userRepository.findByUserRegistrationDateBetween(userRegistrationDate, currentDate);
    }

    public User getUser(Long id) {
        return userRepository.getOne(id);
    }



}
