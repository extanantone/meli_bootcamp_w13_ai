package com.bootcamp.EJREPMessengers.service;

import com.bootcamp.EJREPMessengers.dto.AMensajeroDTO;
import com.bootcamp.EJREPMessengers.model.AMensajero;

import java.util.List;

public interface IMensajeroService {
    public List<AMensajeroDTO> devolverMensajeros();

    public String devolverMensaje(AMensajeroDTO aMensajeroDTO);
}
