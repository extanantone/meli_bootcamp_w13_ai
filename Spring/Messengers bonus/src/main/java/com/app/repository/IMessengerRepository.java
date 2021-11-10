package com.app.repository;

import com.app.model.Messenger;
import com.app.model.Paloma;
import com.app.model.TelefonoCelular;
import com.app.model.Telegrafo;

import java.util.List;

public interface IMessengerRepository {

    List<Messenger> getMessengers();

    Messenger getMessengerById(int id);

    Paloma getPalomaById(int id);

    void updatePaloma(Paloma p);

    TelefonoCelular findTelefonoById(int id);

    void updateTelefono(TelefonoCelular telefonoCelular);

    Telegrafo getTelegrafoById(int id);

    void updateTelegrafo(Telegrafo telegrafo);
}
