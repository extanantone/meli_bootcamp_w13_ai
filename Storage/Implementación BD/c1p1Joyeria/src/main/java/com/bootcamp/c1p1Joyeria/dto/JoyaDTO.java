package com.bootcamp.c1p1Joyeria.dto;

import lombok.Data;

@Data
public class JoyaDTO {
    private Long nroIdentificatorio;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
