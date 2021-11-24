package com.bootcamp.Mensajero.service;

import com.bootcamp.Mensajero.dto.MensajeDTO;
import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.dto.MensajeroTipoDTO;
import com.bootcamp.Mensajero.exception.NotFoundMensajeroException;
import com.bootcamp.Mensajero.model.Mensajero;

import java.util.List;

public interface IMensajeroService {
    MensajeDTO retornarMensaje(Long id, String msj) throws NotFoundMensajeroException;

    List<MensajeroDTO> listarMensajeros();

    MensajeroTipoDTO retornarMensajero(Long id) throws NotFoundMensajeroException;
}
