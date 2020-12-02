package com.martkplaats.backend.repositories;

import com.martkplaats.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service
//@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
