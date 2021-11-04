package com.example.c3_ioc_inyec_depen_vivo_p2.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.StringJoiner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Ingrediente
{
    private String name;
    private int calories;
    private int peso;

    @Override
    public String toString()
    {
        return new StringJoiner(", ", Ingrediente.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("calories=" + calories)
                .add("peso=" + peso)
                .toString();
    }

    public Ingrediente(Ingrediente ingrediente)
    {
        this.name = ingrediente.getName();
        this.calories = ingrediente.getCalories();
        this.peso = ingrediente.getPeso();
    }
}
