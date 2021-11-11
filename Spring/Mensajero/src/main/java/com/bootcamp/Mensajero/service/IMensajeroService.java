package com.bootcamp.Mensajero.service;

import com.bootcamp.Mensajero.dto.MensajeDTO;
import com.bootcamp.Mensajero.dto.MensajeroDTO;

import java.util.List;

public interface IMensajeroService {
    MensajeDTO retornarMensaje(Long idMensajero, String mensajeCustom);
    List<MensajeroDTO> listarMensajeros();
}
