package com.martkplaats.backend.controllers;

import com.martkplaats.backend.model.Product;
import com.martkplaats.backend.model.User;
import com.martkplaats.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable int id) { return userRepository.findById(id); }

    @GetMapping("/users")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
