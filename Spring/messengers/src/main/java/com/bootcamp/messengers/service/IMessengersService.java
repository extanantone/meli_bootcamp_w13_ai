package com.bootcamp.messengers.service;

import com.bootcamp.messengers.dto.*;
import com.bootcamp.messengers.model.Mensajero;

import java.util.List;

public interface IMessengersService {

    List<MensajeroDTO> getMensajeros();
    MensajeDTO getMensaje(Integer id, String msj);
    public void setEstadoPaloma(PalomaStateDTO paloma);
    public void setEstadoCelular(CelularStateDTO celular);
    public void setEstadoTelegrafo(TelegrafoStateDTO telegrafo);

}
