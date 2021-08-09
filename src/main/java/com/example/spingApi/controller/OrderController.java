package com.example.spingApi.controller;

import com.example.spingApi.exception.UserNotFoundException;
import com.example.spingApi.repository.OrderRepository;
import com.example.spingApi.repository.UserRepository;
import com.example.spingApi.restServices.Order;
import com.example.spingApi.restServices.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class OrderController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{id}/orders")
    public List<Order> getAllOrders(@PathVariable("id") Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        return user.get().getOrders();
    }

    @PostMapping("/{id}/orders")
    public Order createOrder(@PathVariable("id") Long id, @RequestBody Order order) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        order.setUser(user.get());
        return orderRepository.save(order);
    }
}
