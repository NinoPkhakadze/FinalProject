package com.example.ninopkhakadze.mychat.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NinoPkhakadze on 12/2/2016.
 */

public class Contacts {

    private List<Contact> contactList;

    public List<Contact> getContactList() {
        if (contactList == null) {

            contactList = new ArrayList<Contact>();
        }
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
