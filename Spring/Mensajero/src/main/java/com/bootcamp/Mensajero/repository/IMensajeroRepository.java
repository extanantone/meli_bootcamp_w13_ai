package com.bootcamp.Mensajero.repository;

import com.bootcamp.Mensajero.model.Mensajero;

import java.util.List;
import java.util.Map;

public interface IMensajeroRepository {
    Map<Long ,Mensajero> listarMensajeros();
    Mensajero getMensajero(long mensajeroId);
}
