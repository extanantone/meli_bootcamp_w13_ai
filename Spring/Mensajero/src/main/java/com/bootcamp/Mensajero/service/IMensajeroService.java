package com.bootcamp.Mensajero.service;

import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.model.Mensajero;

import java.util.List;

public interface IMensajeroService {

   // List<Mensajero> mensajeros ();

    MensajeroDTO getmensajero(Long id, String msg);
}
