package com.martkplaats.backend.repositories;

import com.martkplaats.backend.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    Account findByUsername(String username);
}
