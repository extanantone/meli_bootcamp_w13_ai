package com.bootcamp.EJREPMessengers.repository;

import com.bootcamp.EJREPMessengers.model.AMensajero;

import java.util.List;

public interface IMensajeroRepository {
    public List<AMensajero> buscarMensajeros();

    public String buscarMensajero(AMensajero aMensajero);
}
