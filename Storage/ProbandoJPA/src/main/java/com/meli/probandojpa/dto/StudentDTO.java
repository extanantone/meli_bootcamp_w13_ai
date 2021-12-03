package com.meli.probandojpa.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class StudentDTO {

    private Long id;
    private String dni;
    private String name;
    private String lastName;

}
