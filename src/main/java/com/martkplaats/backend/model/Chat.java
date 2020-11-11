package com.martkplaats.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne()
    @JoinColumn(name = "user_id_seller", nullable = false)
    @JsonBackReference(value = "seller")
    User userSeller;

    @ManyToOne()
    @JoinColumn(name = "user_id_buyer", nullable = false)
    @JsonBackReference(value = "buyer")
    User userBuyer;

    public Chat(User userSeller, User userBuyer) {
        this.userSeller = userSeller;
        this.userBuyer = userBuyer;
    }

    public Chat() {
    }

    public User getUserSeller() {
        return userSeller;
    }

    public void setUserSeller(User userSeller) {
        this.userSeller = userSeller;
    }

    public User getUserBuyer() {
        return userBuyer;
    }

    public void setUserBuyer(User userBuyer) {
        this.userBuyer = userBuyer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<Message> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(List<Message> messages) {
//        this.messages = messages;
//    }
}
