package com.C2P2VIVO.deportistas.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class DeportePersona implements Serializable {
    private String nombrePersona;
    private String apellidoPersona;
    private String nombreDeporte;

    @Override
    public String toString() {
        return "DeportePersona{" +
                "nombrePersona='" + nombrePersona + '\'' +
                ", apellidoPersona='" + apellidoPersona + '\'' +
                ", nombreDeporte='" + nombreDeporte + '\'' +
                '}';
    }
}
