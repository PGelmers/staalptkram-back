package com.martkplaats.backend.controllers;

import com.martkplaats.backend.model.Account;
import com.martkplaats.backend.model.User;
import com.martkplaats.backend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/account")
    int save(@RequestBody Account account) {
        accountRepository.save(account);
        return account.getId();
    }

    @GetMapping("/login")
    User login(@RequestBody String username, String password) {
        Account account = accountRepository.findByUsername(username);
        // TODO: Check username and password
        return account.getUser();
    }
}
