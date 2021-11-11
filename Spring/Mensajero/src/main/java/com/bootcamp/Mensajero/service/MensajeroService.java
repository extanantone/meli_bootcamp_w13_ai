package com.bootcamp.Mensajero.service;

import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.exception.NotFoundException;
import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.repository.IMensajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeroService implements IMensajeroService{
    @Autowired
    IMensajeroRepository iMensajeroRepository;

    @Override
    public MensajeroDTO getmensajero(Long id, String msg) {

        Mensajero mensajero = iMensajeroRepository.getMensajero(id).orElseThrow(()-> new NotFoundException(id));



        return new MensajeroDTO( mensajero.emitirMensaje(msg),id);
    }
}
