package com.martkplaats.backend.repositories;

import com.martkplaats.backend.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
