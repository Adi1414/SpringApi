package com.example.spingApi.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/user-details")
    public UserDetails userDetails(){
        return new UserDetails("Ana","Wills","Hyd");
    }

}
