package com.bootcamp.SpringJPA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String dni;
    private String name;
    private String lastname;
}
