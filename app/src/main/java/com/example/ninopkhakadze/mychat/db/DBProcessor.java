package com.example.ninopkhakadze.mychat.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ninopkhakadze.mychat.common.Constants;
import com.example.ninopkhakadze.mychat.entity.Contact;
import com.example.ninopkhakadze.mychat.entity.Contacts;

/**
 * Created by NinoPkhakadze on 12/2/2016.
 */

public class DBProcessor {

    private Context context;

    public DBProcessor(Context context){
        this.context = context;
    }

    public Contacts getContacts() {

        DBHandler dbHandler = new DBHandler(context);

        SQLiteDatabase db = dbHandler.getWritableDatabase();

        String[] projection = {
                "ID",
                "DISPLAY_NAME",
                "PHONE_NUMBER",
                "AVATAR_IMAGE"
        };

        Cursor cursor = db.query(
                Constants.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        Contacts contacts = new Contacts();

        while (cursor.moveToNext()) {
            Contact contact = new Contact();
            contact.setDisplayName(cursor.getString(cursor.getColumnIndex("DISPLAY_NAME")));
            contact.setAvatarImg(cursor.getString(cursor.getColumnIndex("AVATAR_IMAGE")));
            contact.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            contact.setPhoneNumber(cursor.getString(cursor.getColumnIndex("PHONE_NUMBER")));

            contacts.getContactList().add(contact);
        }

        return contacts;
    }

    public void saveContacts(Contacts contacts) {

        DBHandler dbHandler = new DBHandler(context);
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        for (Contact contact : contacts.getContactList()) {

            ContentValues values = new ContentValues();
            values.put("ID", contact.getId());
            values.put("DISPLAY_NAME", contact.getDisplayName());
            values.put("PHONE_NUMBER", contact.getPhoneNumber());
            values.put("AVATAR_IMAGE", contact.getAvatarImg());

            long newRowId = db.insert(Constants.TABLE_NAME, null, values);
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
