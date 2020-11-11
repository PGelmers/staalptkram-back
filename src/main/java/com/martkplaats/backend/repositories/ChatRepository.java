package com.martkplaats.backend.repositories;

import com.martkplaats.backend.model.Chat;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<Chat, Integer> {

}
