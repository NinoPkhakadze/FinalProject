package com.example.ninopkhakadze.mychat.Classes;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import android.widget.ListView;

import com.example.ninopkhakadze.mychat.ContactAdapter;

import com.example.ninopkhakadze.mychat.entity.Contact;

import java.util.List;

/**
 * Created by NinoPkhakadze on 12/3/2016.
 */

public class GetContacts extends AsyncTask<Void, Void, Void> {

    private ListView listView;

    List<Contact> contacts = null;

    Context context;

    private ProgressDialog pDialog;

    public GetContacts(Context context, ListView listView, List<Contact> contacts) {

        this.context = context;
        this.listView = listView;
        this.contacts = contacts;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

    }

    @Override
    protected Void doInBackground(Void... arg0) {

        LocalDataInitializer initializer = new LocalDataInitializer(context);

        contacts.clear();
        contacts.addAll(initializer.getContactList());
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {

        super.onPostExecute(result);

        if (pDialog.isShowing())
            pDialog.dismiss();

        ((ContactAdapter) listView.getAdapter()).notifyDataSetChanged();

    }

}
