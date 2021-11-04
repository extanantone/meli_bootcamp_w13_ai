package com.example.c3_ioc_inyec_depen_vivo_p2.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.StringJoiner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Plato
{
    private String nombre;
    private List<Ingrediente> ingredienteList;

    @Override
    public String toString()
    {
        return new StringJoiner(", ", Plato.class.getSimpleName() + "[", "]")
                .add("nombre='" + nombre + "'")
                .add("ingredienteList=" + ingredienteList)
                .toString();
    }
}
