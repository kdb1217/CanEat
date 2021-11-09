package com.example.caneat;

public class User {
    public String username;
    public String email;
    public String uid;
    public String data0;
    public String data1;
    public String data2;

    public String getData0() {
        return data0;
    }

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public String getData3() {
        return data3;
    }

    public String getData4() {
        return data4;
    }

    public String getData5() {
        return data5;
    }

    public String data3;
    public String data4;
    public String data5;



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



    public void setData(String data) {
        this.data0 = data;
    }

    public String getData() {
        return data0;
    }

    public User(){

    }

    public User(String username, String email){
        this.username=username;
        this.email=email;
    }
}
