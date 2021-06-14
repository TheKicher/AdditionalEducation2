package com.hfad.aded;

public class User {

   String id, city, name, prof, disc, price, phone, email;

    public User(String id, String city, String name, String prof, String disc, String price, String phone, String email) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.prof = prof;
        this.disc = disc;
        this.price = price;
        this.phone = phone;
        this.email = email;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getProf() {
        return prof;
    }

    public String getDisc() {
        return disc;
    }

    public String getPrice() {
        return price;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}

