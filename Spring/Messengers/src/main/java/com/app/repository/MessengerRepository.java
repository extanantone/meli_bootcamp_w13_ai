package com.app.repository;

import com.app.model.Celular;
import com.app.model.Messenger;
import com.app.model.Paloma;
import com.app.model.Telegrafo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessengerRepository implements IMessengerRepository{

    private List<Messenger> messengers;

    public MessengerRepository(){
        messengers = List.of(new Celular(),new Paloma(),new Telegrafo(),new Paloma());
    }


    @Override
    public List<Messenger> getMessengers() {
        return messengers;
    }

    @Override
    public Messenger getMenssengerById(int id){
        return messengers.stream().filter(it->it.getId()==id).findFirst()
                .orElse(null);
    }


}
