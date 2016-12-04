package com.example.ninopkhakadze.mychat.Classes;

import android.content.Context;

import com.example.ninopkhakadze.mychat.HttpHandler;
import com.example.ninopkhakadze.mychat.common.Constants;
import com.example.ninopkhakadze.mychat.db.DBProcessor;
import com.example.ninopkhakadze.mychat.entity.Contact;
import com.example.ninopkhakadze.mychat.entity.Contacts;
import com.google.gson.Gson;
import java.util.List;

/**
 * Created by NinoPkhakadze on 12/2/2016.
 */

public class LocalDataInitializer {

    private Context context;

    public LocalDataInitializer(Context context){
        this.context = context;
    }

    public List<Contact> getContactList() {

        Contacts contacts = getLocalContacts();

        if(contacts == null || contacts.getContactList().isEmpty()){
            contacts = getRemoteContacts();
            DBProcessor dbProcessor = new DBProcessor(context);
            dbProcessor.saveContacts(contacts);
        }

        return  contacts.getContactList();
    }

    private Contacts getLocalContacts() {

        DBProcessor dbProcessor = new DBProcessor(context);
        return dbProcessor.getContacts();
    }


    private Contacts getRemoteContacts() {

        HttpHandler sh = new HttpHandler();

        String jsonStr = sh.makeServiceCall(Constants.SERVICE_URL);

        Contacts contacts = new Gson().fromJson(jsonStr, Contacts.class);

        return contacts;
    }
}
