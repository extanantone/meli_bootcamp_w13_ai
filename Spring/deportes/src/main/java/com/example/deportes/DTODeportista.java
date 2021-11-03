package com.example.deportes;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class DTODeportista implements Serializable {
    public String nombreCompleto;
    public String nombreDeporte;

    public DTODeportista(String nombreCompleto, String nombreDeporte) {
        this.nombreCompleto = nombreCompleto;
        this.nombreDeporte = nombreDeporte;
    }
}
