package com.bootcamp.demoHibernate.dto;

import lombok.Data;

@Data
//un extendes porque devuelve lo que posee StudentResponseDTO + el id
// mismo objeto => agregandole el id que se autogenera
public class StudentResponseDTO extends StudentRequestDTO{
    private Long id;
}
