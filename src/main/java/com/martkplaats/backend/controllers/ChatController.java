package com.martkplaats.backend.controllers;

import com.martkplaats.backend.model.Message;
import com.martkplaats.backend.repositories.ChatRepository;
import com.martkplaats.backend.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    @MessageMapping("/send/message")
    public void sendMessage(Message message) {
        System.out.print(message.getMessage());
        simpMessagingTemplate.convertAndSendToUser(Integer.toString(message.getChat().getId()), "/queue/messages", message.getMessage());
    }
}
