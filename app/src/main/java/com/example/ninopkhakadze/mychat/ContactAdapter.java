package com.example.ninopkhakadze.mychat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.ninopkhakadze.mychat.Classes.LocalDataInitializer;
import com.example.ninopkhakadze.mychat.common.Constants;
import com.example.ninopkhakadze.mychat.entity.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by NinoPkhakadze on 12/2/2016.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    private List<Contact> friendsList = null;
    LocalDataInitializer initializer;
    Context cont;

    public ContactAdapter(Context context, int layoutResourceId,
                          List<Contact> data) {

        super(context, layoutResourceId, data);
        cont = context;
        friendsList = data;
        initializer = new LocalDataInitializer(context);
    }


    public Context getContext() {
        return cont;
    }

    public Contact getContact(int position) {

        return friendsList.get(position);
    }

    public List<Contact> getContacts() {
        return initializer.getContactList();
    }


    public void ChangeContactsStatus() {

        for (Contact cnt : friendsList) {
            cnt.setOnline(new Random().nextBoolean());
        }
        notifyDataSetChanged();
    }

    @Override
    public Contact getItem(int position) {
        Contact contact = getContact(position);
        return contact;
    }

    @Override
    public int getCount() {
        return friendsList.size();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Contact contact = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView displayName = (TextView) convertView.findViewById(R.id.displayName);
        TextView phoneNumber = (TextView) convertView.findViewById(R.id.phoneNumber);
        ImageView avatarImage = (ImageView) convertView.findViewById(R.id.image);
        ImageView online_bulb = (ImageView) convertView.findViewById(R.id.online_bulb);

        Bitmap bMap;
        if (contact.isOnline()) {
            bMap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.green_bulb);
        } else {
            bMap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.red_bulb);
        }

        online_bulb.setImageBitmap(bMap);
        displayName.setText(contact.getDisplayName());
        phoneNumber.setText(contact.getPhoneNumber());

        Picasso.with(getContext())
                .load(contact.getAvatarImg())
                .resize(Constants.LIST_CONTACT_IMAGE_WIDTH, Constants.LIST_CONTACT_IMAGE_HEIGHT)
                .centerCrop()
                .placeholder(R.drawable.default_avatar)
                .error(R.drawable.default_avatar)
                .into(avatarImage);

        return convertView;
    }


    public void filter(String matchText) {

        matchText = matchText.toLowerCase(Locale.getDefault());

        List<Contact> arrayList = getContacts();
        friendsList.clear();
        if (matchText.length() == 0) {
            friendsList.addAll(arrayList);

        } else {

            for (Contact cnt : arrayList) {

                if (cnt.containsText(matchText)) {
                    friendsList.add(cnt);
                }
            }

        }
        notifyDataSetChanged();
    }

}
