package com.eh.springbootjpa.controller;

import com.eh.springbootjpa.dao.UserRepository;
import com.eh.springbootjpa.entiry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    // 测试：http://localhost:8080/user/1
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    // 测试：http://localhost:8080/user?lastName=lisi&email=lisi@gmail.com
    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}
