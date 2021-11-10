package com.bootcamp.Mensajero.dto;

import com.bootcamp.Mensajero.model.Mensajero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MensajerosDto {
    private Long id;
    private Mensajero nombre;
}
