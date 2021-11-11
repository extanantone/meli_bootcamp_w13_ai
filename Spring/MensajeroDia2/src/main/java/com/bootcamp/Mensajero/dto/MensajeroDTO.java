package com.bootcamp.Mensajero.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MensajeroDTO extends MensajeroTipoDTO{
    Long id;
    public MensajeroDTO(Long id, String type) {
        super(type);
        this.id = id;
    }
}
