package com.example.c3_arq_mult_vivo_p1.service;

import com.example.c3_arq_mult_vivo_p1.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService
{
    List<PersonajeDTO> getPersonajes(String name);
}
