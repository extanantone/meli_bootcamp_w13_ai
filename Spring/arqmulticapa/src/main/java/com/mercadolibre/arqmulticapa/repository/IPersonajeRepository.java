package com.mercadolibre.arqmulticapa.repository;

import com.mercadolibre.arqmulticapa.model.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> buscarPersonaje(String nombre);
}
