package com.example.c3_arq_mult_vivo_p1.repository;

import com.example.c3_arq_mult_vivo_p1.model.Personaje;

import java.util.List;

public interface IPersonajeRepository
{
    List<Personaje> buscarPersonajes(String name);
}
