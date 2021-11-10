package com.bootcamp.Mensajero.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MensajeroDTO {
    long id;
    String clase;
    String plantilla;
}
