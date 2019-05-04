package com.example.travelhacking;

import java.io.Serializable;

public class eatery implements Serializable {

    public String name;
    public String address;
    public String phone;
    public String reviews;
    public String URL;
    public String picture;
    public String rating;

    public eatery(String name, String address, String phone, String reviews, String URL, String picture, String rating){

        this.name = name;
        this.address = address;
        this.phone = phone;
        this.reviews = reviews;
        this.URL =URL;
        this.picture = picture;
        this.rating = rating;
    }


    public eatery(){

    }


}
