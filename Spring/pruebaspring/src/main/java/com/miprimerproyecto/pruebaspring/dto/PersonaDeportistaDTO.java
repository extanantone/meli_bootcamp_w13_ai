package com.miprimerproyecto.pruebaspring.dto;

import com.miprimerproyecto.pruebaspring.model.Deporte;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Setter
@Getter
public class PersonaDeportistaDTO {

    private String nombre;
    private String apellido;
    private List<String > deporte;
}
