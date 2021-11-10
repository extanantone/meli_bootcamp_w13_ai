package com.bootcamp.Mensajero.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MensajeroDto {
    private Long id;
    private  String mensaje;
}
