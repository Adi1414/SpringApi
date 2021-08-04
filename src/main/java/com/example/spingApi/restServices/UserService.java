package com.example.spingApi.restServices;
import com.example.spingApi.exception.UserAlreadyExistException;
import com.example.spingApi.exception.UserNotFoundException;
import com.example.spingApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        Optional<User> user =  userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("User do not exist");
        }
        return user;
    }

    public User createUser(User user) throws UserAlreadyExistException{
        Optional<User> optionalUser = userRepository.findByFirstName(user.getFirstName());
        if(optionalUser.isPresent()){
            throw new UserAlreadyExistException("User Already exist with this firstname");
        }
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) throws UserNotFoundException {
        Optional<User> OptionalUser =  userRepository.findById(id);
        if(!OptionalUser.isPresent()){
            throw new UserNotFoundException("User do not exist");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        Optional<User> OptionalUser =  userRepository.findById(id);
        if(!OptionalUser.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User do not exist");
        }
        userRepository.deleteById(id);
    }

    public Optional<User> getUserByName(String username) {
        return userRepository.findByFirstName(username);
    }
}
