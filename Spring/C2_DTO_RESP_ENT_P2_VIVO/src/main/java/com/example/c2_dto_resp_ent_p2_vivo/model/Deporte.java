package com.example.c2_dto_resp_ent_p2_vivo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.StringJoiner;

@AllArgsConstructor
@Getter
@Setter
public class Deporte
{
    @Override
    public String toString()
    {
        return new StringJoiner(", ", Deporte.class.getSimpleName() + "[", "]")
                .add("nombre='" + nombre + "'")
                .add("nivel='" + nivel + "'")
                .toString();
    }

    private String nombre;
    private String nivel;
}
