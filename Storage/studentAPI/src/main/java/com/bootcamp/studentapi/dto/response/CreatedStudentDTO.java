package com.bootcamp.studentapi.dto.response;

import lombok.Getter;

@Getter
public class CreatedStudentDTO {

    private Integer id;

    private final String message;

    public CreatedStudentDTO(Integer id) {
        this.id = id;
        message = "El estudiante con id " + id + " ha sido creado correctamente";
    }
}
