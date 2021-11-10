package com.bootcamp.EJREPMessengers.dto;

import com.bootcamp.EJREPMessengers.model.AMensajero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AMensajeroDTO {
    private String mensaje;
    private String tipoMensajero;
}
