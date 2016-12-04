package com.example.ninopkhakadze.mychat.Classes;

import com.example.ninopkhakadze.mychat.entity.Message;

/**
 * Created by NinoPkhakadze on 12/4/2016.
 */

public interface ChatEventListener {
    /**
     * იძახება როდესაც იცვლება რომელიმე მეგობრის სტატუსი
     */
    public void contactStatusChanged(int contactId);
    /**
     * იძახება როდესაც ვიღებთ შემომავალ შეტყობინებას რომელიმე მეგობრისგან
     */
    public void incomingMessage(Message m);
}
