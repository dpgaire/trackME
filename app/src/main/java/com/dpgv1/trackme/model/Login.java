package com.dpgv1.trackme.model;

public class Login {
    private String username;

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

    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
