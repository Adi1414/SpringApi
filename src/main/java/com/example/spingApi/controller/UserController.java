package com.example.spingApi.controller;

import com.example.spingApi.restServices.User;
import com.example.spingApi.restServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserByID(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable("id")  Long id){
        userService.deleteUser(id);
    }

    @GetMapping("user/by/{username}")
    public User getUserByName(@PathVariable("username") String username){
        return userService.getUserByName(username);
    }
}
