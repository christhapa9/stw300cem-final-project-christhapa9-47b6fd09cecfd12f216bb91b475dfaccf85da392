package com.example.bookyourvenue.Model;

public class User {
    String userId,userfname,userlname,username,password,email;

    public User(String userfname, String userLname, String username, String password, String email) {
        this.userfname = userfname;
        this.userlname = userlname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String userId, String userfname, String userlname, String username, String password, String email) {
        this.userId = userId;
        this.userfname = userfname;
        this.userlname = userlname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserfname() {
        return userfname;
    }

    public void setUserfname(String userfname) {
        this.userfname = userfname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String password) {
        this.email = email;
    }
}
