package com.detectarDeportistas.ejercicioDeportistas.dto;
import lombok.Getter;

import java.io.Serializable;
@Getter
public class DeportistaDTO implements Serializable{
    private String nombre;
    private String apellido;
    private String nombreDeporte;
    public DeportistaDTO(String nombre,String apellido,String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }
}
