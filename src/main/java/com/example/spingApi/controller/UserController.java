package com.example.spingApi.controller;

import com.example.spingApi.exception.FirstNameNotFoundException;
import com.example.spingApi.exception.UserAlreadyExistException;
import com.example.spingApi.exception.UserNotFoundException;
import com.example.spingApi.restServices.User;
import com.example.spingApi.restServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserByID(@PathVariable("id") @Min(1) Long id){
        try{
            return userService.getUserById(id);
        }
        catch(UserNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@Valid @RequestBody User user, UriComponentsBuilder builder){
        try {
            userService.createUser(user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("user/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
        catch (UserAlreadyExistException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }

    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        try{
            return userService.updateUser(id, user);
        }
        catch (UserNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable("id")  Long id){
        userService.deleteUser(id);
    }

    @GetMapping("user/by/{username}")
    public Optional<User> getUserByName(@PathVariable("username") String username) throws FirstNameNotFoundException {
        Optional<User> user =  userService.getUserByName(username);
        if(!user.isPresent()){
            throw new FirstNameNotFoundException("FirstName " + username + " not found");
        }
        return user;
    }
}
