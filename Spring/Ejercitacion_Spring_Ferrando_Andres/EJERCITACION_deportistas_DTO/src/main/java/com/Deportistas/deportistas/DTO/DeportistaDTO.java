package com.Deportistas.deportistas.DTO;

import com.Deportistas.deportistas.Model.*;
import com.Deportistas.deportistas.Service.serviceDeportes;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class DeportistaDTO {

    String nombre,apellido, nombreDeporte;


    public DeportistaDTO(Deportista d)
    {

        nombre = d.getP().getNombre();
        apellido = d.getP().getApellido();
        nombreDeporte = d.getD().getNombre();

    }
}
