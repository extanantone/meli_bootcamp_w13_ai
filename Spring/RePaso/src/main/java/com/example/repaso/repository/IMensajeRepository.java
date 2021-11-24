package com.example.repaso.repository;

import com.example.repaso.model.Mensajero;

import java.util.List;
import java.util.Map;

public interface IMensajeRepository
{
    Map<Long, Mensajero> mensajeroMap();

    Mensajero getMensajero(Long id);
}
