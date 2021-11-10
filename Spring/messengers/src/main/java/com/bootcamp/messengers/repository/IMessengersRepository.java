package com.bootcamp.messengers.repository;

import com.bootcamp.messengers.model.Mensajero;

import java.util.List;

public interface IMessengersRepository {

    void agregarMensajero(Mensajero m);
    void eliminarMensajero(Mensajero m);
    List<Mensajero> getMensajeros();
    Mensajero buscarMensajero(Integer id);

}
