package com.bootcamp.Mensajero.service;

import com.bootcamp.Mensajero.dto.MensajeroDto;
import com.bootcamp.Mensajero.dto.MensajerosDto;
import com.bootcamp.Mensajero.model.Mensajero;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IMensajeroService {
    List<MensajerosDto> listar();

    MensajeroDto retornarMensaje(String msj, Long id) throws Exception;
}
