package com.martkplaats.backend.controllers;

import com.martkplaats.backend.model.Account;
import com.martkplaats.backend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountRepository loginRepository;

    @PostMapping("/login")
    void save(Account login) {
        loginRepository.save(login);
    }
}
