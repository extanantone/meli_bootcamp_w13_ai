package com.bootcamp.Mensajero.repository;

import com.bootcamp.Mensajero.model.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MensajeroRepository implements IMensajeroRepository {
    Map<Long, MensajeroAbstracto> mensajeros = new HashMap<>();

    public MensajeroRepository() {
        mensajeros.put(0L, new Paloma("Paloma", 50,10));
        mensajeros.put(1L, new Paloma("Paloma",20,4));
        mensajeros.put(2L, new Celular("Celular"));
        mensajeros.put(3L, new Telegrafo("Telegrafo"));
    }
    @Override
    public Map<Long, MensajeroAbstracto> listarMensajeros() {
        return mensajeros;
    }

    @Override
    public Optional<Mensajero> find(Long id) {
        if(mensajeros.containsKey(id)){
            return Optional.of(mensajeros.get(id));
        }
        return Optional.empty();
    }
}
