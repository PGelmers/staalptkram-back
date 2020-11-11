package com.martkplaats.backend.controllers;

import com.martkplaats.backend.model.Chat;
import com.martkplaats.backend.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    ChatRepository chatRepository;

    @PostMapping("/chat")
    void save(@RequestBody Chat chat) {
        chatRepository.save(chat);
    }

    @GetMapping("/chats")
    Iterable<Chat> findAll() {
        return chatRepository.findAll();
    }
}
