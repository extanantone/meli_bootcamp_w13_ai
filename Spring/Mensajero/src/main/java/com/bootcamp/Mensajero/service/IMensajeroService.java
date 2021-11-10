package com.bootcamp.Mensajero.service;

import com.bootcamp.Mensajero.dto.MensajeDTO;
import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.model.MensajeroAbstracto;

import java.util.List;

public interface IMensajeroService {
    // get mensajeros
    public List<MensajeroDTO> getMensajeros();
    // get mensaje
    public MensajeDTO getMensaje(long mensajeroId, String mensaje);
}