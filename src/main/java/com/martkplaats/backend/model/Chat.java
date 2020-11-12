package com.martkplaats.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    String userSellerName;
    String userBuyerName;

    public Chat(User userSeller, User userBuyer) {
        this.userSeller = userSeller;
        this.userBuyer = userBuyer;
        this.userSellerName = userSeller.getFirstName();
        this.userBuyerName = userBuyer.getFirstName();
    }

    public Chat() {
    }

    public String getUserSellerName() {
        return userSellerName;
    }

    public void setUserSellerName(String userSellerName) {
        this.userSellerName = userSellerName;
    }

    public String getUserBuyerName() {
        return userBuyerName;
    }

    public void setUserBuyerName(String userBuyerName) {
        this.userBuyerName = userBuyerName;
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
