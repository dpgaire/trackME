package com.dpgv1.trackme.model;

import java.util.ArrayList;
import java.util.List;

public class AddFriend {

    static List<AddFriend> addFriendList = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public AddFriend(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public static List<AddFriend> getAddFriendList() {
        return addFriendList;
    }

    public static void setAddFriendList(List<AddFriend> addFriendList) {
        AddFriend.addFriendList = addFriendList;
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
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
