package com.dpgv1.trackme.model;

public class User {

    private String firstName;
    private String lastName;
    private String address;
    private String username;
    private String password;
    private String image;

    public User(String firstName, String lastName, String phoneNumber, String username, String password,String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = phoneNumber;
        this.username = username;
        this.password = password;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.address = phoneNumber;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
