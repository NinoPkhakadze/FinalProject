package com.example.ninopkhakadze.mychat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ninopkhakadze.mychat.Classes.ChatEventListener;
import com.example.ninopkhakadze.mychat.entity.Message;

/**
 * Created by NinoPkhakadze on 12/4/2016.
 */

public class ChatActivity extends AppCompatActivity implements ChatEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    @Override
    public void contactStatusChanged(int contactId) {

    }

    @Override
    public void incomingMessage(Message m) {

    }
}
