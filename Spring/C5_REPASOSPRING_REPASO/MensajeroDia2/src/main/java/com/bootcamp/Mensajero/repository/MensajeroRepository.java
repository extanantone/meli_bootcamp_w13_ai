package com.bootcamp.Mensajero.repository;

import com.bootcamp.Mensajero.model.CellphoneMessager;
import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.model.Paloma;
import com.bootcamp.Mensajero.model.Telegrafo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MensajeroRepository implements IMensajeroRepository{
    Map<Long, Mensajero> mensajeros = new HashMap<>();

    public MensajeroRepository() {
        mensajeros.put(0L, new Paloma() );
        mensajeros.put(1L, new Paloma() );
        mensajeros.put(2L, new CellphoneMessager() );
        mensajeros.put(3L, new Telegrafo() );

    }

    @Override
    public Set<Map.Entry<Long, Mensajero>> findAll() {
        return mensajeros.entrySet();
    }

    @Override
    public Optional<Mensajero> find(Long id) {
        if( mensajeros.containsKey( id ) ) {
            return Optional.of( mensajeros.get(id) );
        }
        return Optional.empty();
    }
}
