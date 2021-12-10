package com.ejercicio.studentJPA.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO
{
    private Long id;
    private String dni;
    private String name;
    private String lastName;
}
