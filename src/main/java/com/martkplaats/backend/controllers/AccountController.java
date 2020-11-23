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

    @PostMapping("/login")
    User login(@RequestBody Account accountFromFront) {
        Account accountFromDB = accountRepository.findByUsername(accountFromFront.getUsername());
        if (accountFromDB == null) {
            return new User();
        } else {
            // Check if password matches the username
            if (accountFromFront.getPassword().equals(accountFromDB.getPassword())) {
                return accountFromDB.getUser();
            } else {
                return new User();
                // TODO: Wrong password action here:
                //  Right now just an empty user return for username and password failure.
            }
        }
    }
}
