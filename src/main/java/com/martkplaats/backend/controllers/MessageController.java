//package com.martkplaats.backend.controllers;
//
//import com.martkplaats.backend.model.Message;
//import com.martkplaats.backend.model.Product;
//import com.martkplaats.backend.repositories.MessageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class MessageController {
//    @Autowired
//    MessageRepository messageRepository;
//
//    @PostMapping("/message")
//    void save(@RequestBody Message message) {
//        messageRepository.save(message);
//    }
//}
