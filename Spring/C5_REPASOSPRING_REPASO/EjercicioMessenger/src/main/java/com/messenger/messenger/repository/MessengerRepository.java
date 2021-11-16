package com.messenger.messenger.repository;

import com.messenger.messenger.model.Courier;
import com.messenger.messenger.model.MessengerPigeon;
import com.messenger.messenger.model.Phone;
import com.messenger.messenger.model.Telegraph;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessengerRepository {
    private List<Courier> messengerList = new ArrayList<Courier>(){
        {
            add(new MessengerPigeon());
            add(new MessengerPigeon());
            add(new Phone());
            add(new Telegraph());
        }
    };


    public void initMessengerList(){
        messengerList.add(new MessengerPigeon());
        messengerList.add(new MessengerPigeon());
        messengerList.add(new Phone());
        messengerList.add(new Telegraph());
    }

    public List<Courier> getMessengerList() {
        return messengerList;
    }
}
