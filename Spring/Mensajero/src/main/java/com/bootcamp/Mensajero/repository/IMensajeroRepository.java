package com.bootcamp.Mensajero.repository;

import com.bootcamp.Mensajero.model.Mensajero;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface IMensajeroRepository {
    Set<Map.Entry<Long, Mensajero>> listarMensajeros();
    Optional<Mensajero> find(Long id);
}
