package com.informatorioblog.blog.controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.informatorioblog.blog.dto.UserDTO;
import com.informatorioblog.blog.entities.User;
import com.informatorioblog.blog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user){
    	userService.createUser(user);
    	return new ResponseEntity<> ("Usuario creado.", HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteUser(@Valid @RequestBody UserDTO userDTO){
    	userService.deleteUser(userDTO.getUserID());
    	return new ResponseEntity<> ("Usuario eliminado.", HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> editUser(@Valid @RequestBody UserDTO userDTO){
        User user = userDTO.getUser();
        userService.editUser(user, userDTO.getUserID());
        return new ResponseEntity<> ("Usuario actualizado.", HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK); 
    }

    @GetMapping( path = "/Resistencia")
    public ResponseEntity<?> getUserByCity() {
        List<User> users = userService.getUserByCity("Resistencia");
        return new ResponseEntity<>(users, HttpStatus.OK); 
    }

    @GetMapping( path = "/date/{date}") 
    public ResponseEntity<?> getUserByRegistrationDate(@PathVariable String date) {
        Timestamp currentDate = new Timestamp(new Date().getTime());
        Timestamp dateOfSearch = Timestamp.valueOf(date + " 00:00:00");
        List<User> users = userService.getUserByRegistrationDate(dateOfSearch, currentDate);
        if(users.size() > 0) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>("No se encontraron usuarios.", HttpStatus.OK); 
    }

}
