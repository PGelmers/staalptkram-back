package com.martkplaats.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "image_table")
public class Image {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Deze ID dan opslaan in het Item object

    @Column(name="name")
    private String name;
    // Dit eventueel veranderen naar een unieke random code

    @Column(name="type")
    private String type;

    //image bytes can have large lengths so we specify a value which is more than the default length for picByte column
    //More or less length = 40.000 for an image of 40kB
    @Column(name = "picByte", length = 100_000)
    private byte[] picByte;

    public Image() {
        super();
    }

    public Image(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}
