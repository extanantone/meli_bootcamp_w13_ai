package com.example.c2_dto_resp_ent_p2_vivo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Persona
{
    private String nombre;
    private String apellido;
    private int edad;
    private List<Deporte> deportes;
}
