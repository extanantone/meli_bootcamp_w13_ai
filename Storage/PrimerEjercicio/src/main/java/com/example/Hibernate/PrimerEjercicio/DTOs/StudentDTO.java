package com.example.Hibernate.PrimerEjercicio.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private  Long id;
    private Long dni;
    private String name;
    private String  lastname;
    private Double parcial1;
    private Double parcial2;
    private Double trabajoIntegrador;
}
