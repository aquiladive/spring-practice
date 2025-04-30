package com.example.library.web.controller;

import com.example.library.data.entity.Book;
import com.example.library.data.entity.User;
import com.example.library.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOpController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/listAllUsers")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/api/heldList")
    public Iterable<Book> getHeldBooks(Integer userId) {
        User user = userRepository.findUserById(userId);
        return user.getHeldBooks();
    }

    @GetMapping("/api/getUserId")
    public Integer getUserId(String userName) {
        User user = userRepository.findUserByName(userName);
        return user.getId();
    }
}
