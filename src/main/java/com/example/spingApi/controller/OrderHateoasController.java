package com.example.spingApi.controller;

import com.example.spingApi.exception.UserNotFoundException;
import com.example.spingApi.repository.UserRepository;
import com.example.spingApi.restServices.Order;
import com.example.spingApi.restServices.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/hateoas")
public class OrderHateoasController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}/orders")
    public List<Order> getAllOrders(@PathVariable("id") Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        return user.get().getOrders();
    }

}
