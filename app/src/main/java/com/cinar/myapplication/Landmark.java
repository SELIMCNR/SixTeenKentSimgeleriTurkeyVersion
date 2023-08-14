package com.cinar.myapplication;

import java.io.Serializable;

public class Landmark implements Serializable {
    String name;
    String country;
    int image;


    public  Landmark (String name , String country,int image) {
        this.country = country;
        this.name =name;
        this.image = image;

    }
}
