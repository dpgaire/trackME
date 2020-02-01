package com.dpgv1.trackme.model;

public class AddFriend {

    private String firstName;
    private String LastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public AddFriend(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
    }

    private String PhoneNumber;

}
