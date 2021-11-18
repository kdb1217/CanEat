package com.example.caneat;

public class User {
    public String username;
    public String email;
    public String uid;
    public String ingredient;

    public String getIngredient() {
        return ingredient;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getUid() {
        return uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public User(){}

    public User(String username, String email){
        this.username=username;
        this.email=email;
    }
}
