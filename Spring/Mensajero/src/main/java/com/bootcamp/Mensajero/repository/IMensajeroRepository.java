package com.bootcamp.Mensajero.repository;

import com.bootcamp.Mensajero.model.Mensajero;

import java.util.List;
import java.util.Optional;

public interface IMensajeroRepository {
    List<Mensajero> listarMensajeros();
    Optional<Mensajero> getMensajero(Long id);
}
