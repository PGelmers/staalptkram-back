package com.martkplaats.backend.model;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id_sender", nullable = false)
//    User userSender;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id_receiver)", nullable = false)
//    User userReceiver;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_id", nullable = false)
    Chat chat;

    String message;

    public Message(Chat chat, String message) {
        this.chat = chat;
        this.message = message;
    }

    //    public Message(User userSender, User userReceiver, Chat chat, String message) {
//        this.userSender = userSender;
//        this.userReceiver = userReceiver;
//        this.chat = chat;
//        this.message = message;
//    }

    public Message() {

    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public User getUserSender() {
//        return userSender;
//    }
//
//    public void setUserSender(User userSender) {
//        this.userSender = userSender;
//    }
//
//    public User getUserReceiver() {
//        return userReceiver;
//    }
//
//    public void setUserReceiver(User userReceiver) {
//        this.userReceiver = userReceiver;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
