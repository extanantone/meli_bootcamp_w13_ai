package com.joyeria.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JoyaDto {

    private MaterialDto material;
    private double peso;
    private String particularidad;
    private boolean poseePriedra;
}
