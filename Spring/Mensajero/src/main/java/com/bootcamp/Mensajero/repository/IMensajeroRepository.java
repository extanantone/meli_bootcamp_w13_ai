package com.bootcamp.Mensajero.repository;

import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.model.MensajeroAbstracto;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface IMensajeroRepository {
    Map<Long, MensajeroAbstracto> listarMensajeros();
    Optional<Mensajero> find(Long id);

}
