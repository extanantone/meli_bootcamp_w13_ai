package com.sports.apideportistas.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeportistaDTO {

    private String nombre;

    private String apellido;

    private String nombreDeporte;
}
