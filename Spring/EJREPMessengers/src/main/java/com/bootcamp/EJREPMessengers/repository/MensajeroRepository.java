package com.bootcamp.EJREPMessengers.repository;

import com.bootcamp.EJREPMessengers.model.AMensajero;
import com.bootcamp.EJREPMessengers.model.PalomaMensajera;
import com.bootcamp.EJREPMessengers.model.TelefonoCelular;
import com.bootcamp.EJREPMessengers.model.Telegrafo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MensajeroRepository implements IMensajeroRepository {

    List<AMensajero> listaMensajeros = new ArrayList<>();

    public MensajeroRepository() {
        AMensajero paloma1 = new PalomaMensajera("Soy la paloma 1");
        AMensajero paloma2 = new PalomaMensajera("Soy la paloma 2");
        AMensajero celular = new TelefonoCelular("Soy un teléfono");
        AMensajero telegrafo = new Telegrafo("Soy un telégrafo");
        listaMensajeros.add(paloma1);
        listaMensajeros.add(paloma2);
        listaMensajeros.add(celular);
        listaMensajeros.add(telegrafo);
    }

    @Override
    public List<AMensajero> buscarMensajeros() {
        return this.listaMensajeros;
    }

    @Override
    public String buscarMensajero(AMensajero aMensajero) {
        return aMensajero.convertirMensaje(aMensajero.getMensaje());
    }
}
