package com.martkplaats.backend.controllers;

import com.martkplaats.backend.model.User;
import com.martkplaats.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    Iterable<User> findALl() {
        return userRepository.findAll();
    }

    @PutMapping("/user")
    User update(@RequestBody User user) {
        return userRepository.save(user);
    }
}
