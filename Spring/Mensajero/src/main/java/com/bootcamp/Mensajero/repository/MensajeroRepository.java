package com.bootcamp.Mensajero.repository;

import com.bootcamp.Mensajero.model.Celular;
import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.model.Paloma;
import com.bootcamp.Mensajero.model.Telegrafo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MensajeroRepository implements  IMensajeroRepository{
    Map<Long, Mensajero> mensajeros = new HashMap<>();

    public MensajeroRepository() {
        mensajeros.put(0L, new Paloma() );
        mensajeros.put(1L, new Paloma() );
        mensajeros.put(2L, new Celular() );
        mensajeros.put(3L, new Telegrafo() );
    }

    @Override
    public List<Mensajero> listarMensajeros() {
        return null;
    }

    @Override
    public Optional<Mensajero> getMensajero(Long id) {

        if(mensajeros.containsKey(id)){
            return Optional.of( mensajeros.get(id));
        }

        return Optional.empty();
    }
}
