package com.bootcamp.messengers.repository;

import com.bootcamp.messengers.model.Mensajero;
import com.bootcamp.messengers.model.PalomaMensajera;
import com.bootcamp.messengers.model.TelefonoCelular;
import com.bootcamp.messengers.model.Telegrafo;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessengersRepository implements IMessengersRepository{
    private List<Mensajero> listaMensajeros;

    public MessengersRepository() {
        this.listaMensajeros = new ArrayList<>();
        this.listaMensajeros.add(new PalomaMensajera(1, 5, Instant.MIN));
        this.listaMensajeros.add(new PalomaMensajera(2, 2, Instant.MIN));
        this.listaMensajeros.add(new TelefonoCelular(3, 3, 2));
        this.listaMensajeros.add(new Telegrafo(4, true));
    }

    @Override
    public void agregarMensajero(Mensajero m){
        this.listaMensajeros.add(m);
    }

    @Override
    public void eliminarMensajero(Mensajero m){
        this.listaMensajeros.remove(m);
    }

    @Override
    public List<Mensajero> getMensajeros(){
        return this.listaMensajeros;
    }

    @Override
    public Mensajero buscarMensajero(Integer id){
        return this.listaMensajeros.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

}
