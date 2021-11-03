package com.example.demo.dto;

import com.example.demo.model.Deporte;
import com.example.demo.model.Persona;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDeporteDTO {
    private String nombrePersona;
    private String apellidoPersona;
    private String nombreDeporte;

    public PersonaDeporteDTO(Persona persona) {
        this.nombrePersona = persona.getNombre();
        this.apellidoPersona = persona.getApellido();
        this.nombreDeporte = persona.getDeporte().getNombre();
    }

}
