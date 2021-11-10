package com.bootcamp.messengers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CelularStateDTO {
    private Integer id;
    private Integer porcentaje_bateria;
    private Integer datos_internet; //en KB
}
