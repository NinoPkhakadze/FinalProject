package com.example.ninopkhakadze.mychat.common;

/**
 * Created by NinoPkhakadze on 12/2/2016.
 */

public class Constants {

    public static final String SERVICE_URL = "https://dl.dropboxusercontent.com/u/28030891/FreeUni/Android/assinments/contacts.json";

    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";

    public static final String TABLE_NAME = "CONTACTS";

    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    "ID" + " INTEGER PRIMARY KEY," +
                    "DISPLAY_NAME" + TEXT_TYPE + COMMA_SEP +
                    "PHONE_NUMBER" + TEXT_TYPE + COMMA_SEP +
                    "AVATAR_IMAGE" + TEXT_TYPE + ")";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Contacts.db";
    public static final int INCOMING_MESSAGE_PERIOD=5000;
    public static final double NOTIFICATION_INCOME_PROBABILITY=0.6;
    public static final int RESPONSE_MAX_DELAY=9000;
    public static final int RESPONSE_MIN_DELAY=3000;
    public static final int LIST_CONTACT_IMAGE_WIDTH=170;
    public static final int LIST_CONTACT_IMAGE_HEIGHT=170;


}
