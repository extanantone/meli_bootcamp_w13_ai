package com.bootcamp.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO implements Serializable {
    private String nombreCompleto; //nombre y apellido de la persona
    private List<String> deportesQueRealiza; //lista de los nombres de los deportes que realiza

}
