package com.ejDeportistas.calculandodeportistas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class PersonaDeporteDto implements Serializable {
    private String name;
    private String lastname;
    private String sport;
}
