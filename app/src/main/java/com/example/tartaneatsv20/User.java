package com.example.tartaneatsv20;

import com.google.firebase.database.IgnoreExtraProperties;

public class User {
    public String name;
    public double latitude;
    public double longitude;
    public double block_price;
    public double dinex_price;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String uid) {
        name = uid;
    }

    public User(String uid, double block_price) {
        name = uid;
        this.block_price = block_price;
    }

    public User(double block_price, double dinex_price) {
        this.dinex_price = dinex_price;
        this.block_price = block_price;
    }

    public String getId() {
        return name;
    }

    public final void setId(String uid) {
        name = uid;
    }
}