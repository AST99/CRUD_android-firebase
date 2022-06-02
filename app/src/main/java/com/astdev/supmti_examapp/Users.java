package com.astdev.supmti_examapp;

public class Users {
    public String username, email, phone, passWrd;

    public Users() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Users(String username, String email, String phone, String passWrd) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.passWrd = passWrd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWrd() {
        return passWrd;
    }

    public void setPassWrd(String passWrd) {
        this.passWrd = passWrd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
