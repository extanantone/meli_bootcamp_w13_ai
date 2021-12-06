package com.example.Hibernate.PrimerEjercicio.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {

    private Long id;
    private String message;
}
