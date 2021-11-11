package com.bootcamp.apimessengers.repository;

import com.bootcamp.apimessengers.entitiy.Messenger;
import com.bootcamp.apimessengers.entitiy.Phone;
import com.bootcamp.apimessengers.entitiy.Pigeon;
import com.bootcamp.apimessengers.entitiy.Telegraph;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
public class MessengerReposirotyImpl implements IMessengerRepository{

    private Map<Long, Messenger> messengers;

    public MessengerReposirotyImpl() {
        this.messengers = new HashMap<>();
        this.messengers.put(0L,new Pigeon());
        this.messengers.put(1L,new Pigeon());
        this.messengers.put(2L,new Phone());
        this.messengers.put(3L,new Telegraph());
        this.messengers.put(4L,new Phone());
    }

    @Override
    public Optional<Messenger> getMessenger(Long idMessenger){
        var n = messengers.entrySet();
        return (messengers.containsKey(idMessenger))
                ? Optional.of(messengers.get(idMessenger))
                : Optional.empty();
    }

    @Override
    public Set<Map.Entry<Long,Messenger>> findAll(){
        return messengers.entrySet();
    }
}
