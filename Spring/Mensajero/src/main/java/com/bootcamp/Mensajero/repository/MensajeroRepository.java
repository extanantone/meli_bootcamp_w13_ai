package com.bootcamp.Mensajero.repository;

import com.bootcamp.Mensajero.model.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MensajeroRepository implements IMensajeroRepository{
    Map<Long, Mensajero> mensajeros = new HashMap<>();

    public MensajeroRepository() {
        mensajeros.put(0L, new Paloma() );
        mensajeros.put(1L, new Paloma() );
        mensajeros.put(2L, new Celular() );
        mensajeros.put(3L, new Telegrafo() );
    }

    @Override
    public Map<Long,Mensajero> listarMensajeros() {
        return mensajeros;
    }

    @Override
    public Mensajero getMensajero(long mensajeroId) {
        return mensajeros.get(mensajeroId);
    }


}
