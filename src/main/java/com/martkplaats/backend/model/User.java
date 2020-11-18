package com.martkplaats.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String surname;
    private String email;
    private String telephone;
    private String latitude;
    private String longitude;
    private LocalDate registration = LocalDate.now();

    @OneToMany(mappedBy = "userSeller", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "seller")
    List<Chat> chatsSeller = new ArrayList<Chat>();

    @OneToMany(mappedBy = "userBuyer", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "buyer")
    List<Chat> chatsBuyer = new ArrayList<Chat>();

    public User(String firstName, String surname, String email, String telephone,
                String latitude, String longitude, String plaatsnaam) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public User() {

    }

    public List<Chat> getChatsSeller() {
        return chatsSeller;
    }

    public void setChatsSeller(List<Chat> chatsSeller) {
        this.chatsSeller = chatsSeller;
    }

//    public List<Chat> getChatsBuyer() {
//        return chatsBuyer;
//    }
//
//    public void setChatsBuyer(List<Chat> chatsBuyer) {
//        this.chatsBuyer = chatsBuyer;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDate registration) {
        this.registration = registration;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String straatnaam) {
        this.latitude = straatnaam;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String huisnummer) {
        this.longitude = huisnummer;
    }
}
