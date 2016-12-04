package com.example.ninopkhakadze.mychat.entity;

import android.graphics.Bitmap;

import java.util.Random;

/**
 * Created by NinoPkhakadze on 12/2/2016.
 */

public class Contact {

    private Integer id;
    private String displayName;
    private String phoneNumber;
    private String avatarImg;
    private boolean isOnline = false;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    private Bitmap bitmap;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatarImg() {
        return avatarImg;
    }

    public boolean containsText(String matchText) {
        if (displayName.toLowerCase().contains(matchText))
            return true;

        if (phoneNumber.toLowerCase().contains(matchText))
            return true;

        return false;
    }

    public boolean isOnline() {

        return new Random().nextBoolean();

    }


    public void setOnline(boolean onl) {

        isOnline = onl;

    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }
}
