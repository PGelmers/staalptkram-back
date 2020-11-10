package com.martkplaats.backend.repositories;

import com.martkplaats.backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
