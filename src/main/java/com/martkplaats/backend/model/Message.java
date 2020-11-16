package com.martkplaats.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idSender;
    private int idReceiver;

    @ManyToOne()
    @JoinColumn(name = "chat_id", nullable = false)
    @JsonBackReference(value = "chat")
    private Chat chat;

    private String message;
    private Date timestamp;

    public Message(int idSender, int idReceiver, Chat chat, String message, Date timestamp) {
        this.idSender = idSender;
        this.idReceiver = idReceiver;
        this.chat = chat;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Message() {

    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
