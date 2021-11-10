package com.app.repository;

import com.app.model.Messenger;
import com.app.model.Paloma;
import com.app.model.TelefonoCelular;
import com.app.model.Telegrafo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessengerRepository implements IMessengerRepository{

    private List<Messenger> messengers;

    private List<Paloma> palomas;

    private List<Telegrafo> telegrafos;

    private List<TelefonoCelular> telefonoCelulars;

    public MessengerRepository(){
        Paloma p1 = new Paloma();
        Paloma p2 = new Paloma();
        Telegrafo t=new Telegrafo();
        TelefonoCelular tc=new TelefonoCelular();
        messengers=List.of(p1,p2,t,tc);
        palomas=List.of(p1,p2);
        telegrafos=List.of(t);
        telefonoCelulars=List.of(tc);

    }


    @Override
    public List<Messenger> getMessengers() {
        return messengers;
    }

    @Override
    public Messenger getMessengerById(int id) {
        return messengers.stream().filter(i->i.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Paloma getPalomaById(int id) {
        return palomas.stream().filter(i->i.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void updatePaloma(Paloma p) {

    }

    @Override
    public TelefonoCelular findTelefonoById(int id) {
        return telefonoCelulars.stream().filter(i->i.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void updateTelefono(TelefonoCelular telefonoCelular) {

    }

    @Override
    public Telegrafo getTelegrafoById(int id) {
        return telegrafos.stream().filter(i->i.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void updateTelegrafo(Telegrafo telegrafo) {

    }
}
