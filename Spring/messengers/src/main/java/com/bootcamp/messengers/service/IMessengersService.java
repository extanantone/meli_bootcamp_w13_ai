package com.bootcamp.messengers.service;

import com.bootcamp.messengers.dto.MensajeDTO;
import com.bootcamp.messengers.dto.MensajeroDTO;
import com.bootcamp.messengers.model.Mensajero;

import java.util.List;

public interface IMessengersService {

    List<MensajeroDTO> getMensajeros();
    MensajeDTO getMensaje(Integer id, String msj);

}
