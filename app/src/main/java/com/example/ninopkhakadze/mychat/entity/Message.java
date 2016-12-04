package com.example.ninopkhakadze.mychat.entity;

import java.util.Date;

/**
 * Created by NinoPkhakadze on 12/4/2016.
 */

public class Message {
    private int id;
    private String Text;
    private java.util.Date Date;
    private Boolean IsSent;
    private Boolean isSeen;
    private int ContactId;

    public Message() {
    }


    public Message(int contactId, String text, java.util.Date date, Boolean isSent, Boolean isSeen, int id) {
        ContactId = contactId;
        Text = text;
        Date = date;
        IsSent = isSent;
        this.isSeen = isSeen;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getSent() {
        return IsSent;
    }

    public void setSent(Boolean sent) {
        IsSent = sent;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    public java.util.Date getDate() {

        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public int getContactId() {
        return ContactId;
    }

    public void setContactId(int contactId) {
        ContactId = contactId;
    }
}
