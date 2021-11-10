package com.bootcamp.Mensajero.service;

import com.bootcamp.Mensajero.dto.MensajeroDto;
import com.bootcamp.Mensajero.dto.MensajerosDto;
import com.bootcamp.Mensajero.exception.NotFoundMensajero;
import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.repository.IMensajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MensajeroService implements IMensajeroService {
    @Autowired
    IMensajeroRepository mensajeroRepository;


    @Override
    public List<MensajerosDto> listar() {
        Set<Map.Entry<Long, Mensajero>> entries = mensajeroRepository.listarMensajeros();
        List<MensajerosDto> mensajeros = null;
        for(Map.Entry<Long,Mensajero> kv : entries){
            MensajerosDto msj = new MensajerosDto(kv.getKey(), kv.getValue());
            mensajeros.add(msj);
        }
        return mensajeros;
    }

    public MensajeroDto retornarMensaje(String msj, Long id) {
        Mensajero mensajero = mensajeroRepository.find(id).orElseThrow(() -> new NotFoundMensajero(id));
        return new MensajeroDto(id, mensajero.emitirMensaje(msj));
    }
}
