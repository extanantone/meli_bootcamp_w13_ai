package com.bootcamp.Mensajero.repository;

import com.bootcamp.Mensajero.model.Celular;
import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.model.Paloma;
import com.bootcamp.Mensajero.model.Telégrafo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MensajeroRepository implements IMensajeroRepository {
    Map<Long, Mensajero> mensajeros = new HashMap<>();

    public MensajeroRepository() {
        mensajeros.put(0L, new Paloma() );
        mensajeros.put(1L, new Paloma() );
        mensajeros.put(2L, new Celular() );
        mensajeros.put(3L, new Telégrafo() );
    }

    @Override
    public Set<Map.Entry<Long, Mensajero>> listarMensajeros() {
        return mensajeros.entrySet();
    }

    @Override
    public Optional<Mensajero> find(Long id){
        if (!this.mensajeros.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(this.mensajeros.get(id));
    }
}
