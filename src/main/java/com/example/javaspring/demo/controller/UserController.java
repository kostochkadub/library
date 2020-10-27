package com.example.javaspring.demo.controller;


import com.example.javaspring.demo.model.Author;
import com.example.javaspring.demo.model.Book;
import com.example.javaspring.demo.model.User;
import com.example.javaspring.demo.repository.AuthorRepository;
import com.example.javaspring.demo.repository.BookRepository;
import com.example.javaspring.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/generateUser")
    public User generate(){
        User user = new User();
        user.setName("test_user_1");

        User save = userRepository.save(user);

        return save;
    }

    @GetMapping("/user")
    public List<User> getAll(){
        return userRepository.findAll();

    }


}
