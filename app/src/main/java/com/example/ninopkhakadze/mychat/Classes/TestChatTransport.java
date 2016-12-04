package com.example.ninopkhakadze.mychat.Classes;

import android.support.annotation.NonNull;

import com.example.ninopkhakadze.mychat.common.Constants;
import com.example.ninopkhakadze.mychat.entity.Contact;
import com.example.ninopkhakadze.mychat.entity.Message;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by NinoPkhakadze on 12/4/2016.
 */

public class TestChatTransport {

    private ChatEventListener chatEventListener;
    private Random random;
    private Thread generateEvents;
    private LocalDataInitializer localDataInitializer;

    public TestChatTransport() {
        this.random =  new Random();
    }

    public void incomingMessage(Message m) {
        if (generateEvents != null)
            return;

        generateEvents = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(Constants.INCOMING_MESSAGE_PERIOD);
                        if (random.nextDouble() < Constants.NOTIFICATION_INCOME_PROBABILITY) {
                            sendMessageFromRandomFriend();
                        } else {
                            changeOnlineStatusOfRandomFriend();
                        }
                    }  catch (InterruptedException ignored) {
                        break;
                    }
                }
            }
        });
        generateEvents.start();

    }
    private void changeOnlineStatusOfRandomFriend() {
        int randomFriendId = getRandomContactId();
        if (chatEventListener != null)
            chatEventListener.contactStatusChanged(randomFriendId);
    }
    private void sendMessageFromRandomFriend() {
        int sender = getRandomContactId();
        Message messages = getRandomMessageFrom(sender);
        if (chatEventListener != null)
            chatEventListener.incomingMessage(messages);
    }

    @NonNull
    private Message getRandomMessageFrom(int sender) {
        Message messages = new Message();
        messages.setContactId(sender);
        messages.setText(getRandomText());
        messages.setSent(false);
        messages.setSeen(false);
        messages.setDate(new Date());
        return messages;
    }

    private Message getRandomMessageFrom(int sender, boolean isResponse) {
        Message res = getRandomMessageFrom(sender);
        if (isResponse)
            res.setText("Response text");
        return res;
    }

    private String getRandomText() {
        return "what's up";
    }

    private int getRandomContactId() {

        List<Contact> contactsList = localDataInitializer.getContactList();

        Contact contact = contactsList.get(random.nextInt(contactsList.size()));
        return contact.getId();
    }

    public void sendMessage(Message m) {
        final int contactId = m.getContactId();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long timeToSleep = random.nextInt(Constants.RESPONSE_MAX_DELAY - Constants.RESPONSE_MIN_DELAY + 1000)
                        + Constants.RESPONSE_MIN_DELAY;

                try {
                    Thread.sleep(timeToSleep);
                    Message message = getRandomMessageFrom(contactId, true);
                    message.setText(message.getText());
                    if (chatEventListener != null)
                        chatEventListener.incomingMessage(message);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            }
        }).start();
    }

    public void setChatEventListener(ChatEventListener chatEventListener) {
        this.chatEventListener = chatEventListener;
    }

    public void stopListeningChatEvents() {
        if (generateEvents != null)
            generateEvents.interrupt();
    }




}
