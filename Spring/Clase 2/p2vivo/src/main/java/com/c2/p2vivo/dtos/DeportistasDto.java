package com.c2.p2vivo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class DeportistasDto implements Serializable {
    String nombre;
    String apellido;
    String nombreDeporte;
}
