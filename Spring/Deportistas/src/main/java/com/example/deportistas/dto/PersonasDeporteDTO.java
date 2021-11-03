package com.example.deportistas.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class PersonasDeporteDTO {
    private String nombre;
    private String apellido;
    private String deporte;

    public PersonasDeporteDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }
}
