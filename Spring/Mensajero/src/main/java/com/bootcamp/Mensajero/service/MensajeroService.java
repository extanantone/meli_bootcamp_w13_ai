package com.bootcamp.Mensajero.service;

import com.bootcamp.Mensajero.dto.MensajeroDto;
import com.bootcamp.Mensajero.dto.MensajerosDto;
import com.bootcamp.Mensajero.exception.NotFoundMensajero;
import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.model.MensajeroAbstracto;
import com.bootcamp.Mensajero.repository.IMensajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MensajeroService implements IMensajeroService {
    @Autowired
    IMensajeroRepository mensajeroRepository;


    @Override
    public List<MensajerosDto> listar() {
        Map<Long, MensajeroAbstracto> entries = mensajeroRepository.listarMensajeros();
        List<MensajerosDto> mensajeros = new ArrayList<>();
        for (Map.Entry<Long, MensajeroAbstracto > entry : entries.entrySet()) {
            MensajerosDto msj = new MensajerosDto(entry.getKey(), entry.getValue().getTipo());
            mensajeros.add(msj);
        }
        return mensajeros;
    }

    public MensajeroDto retornarMensaje(String msj, Long id) {
        Mensajero mensajero = mensajeroRepository.find(id).orElseThrow(() -> new NotFoundMensajero(id));
        return new MensajeroDto(id, mensajero.emitirMensaje(msj));
    }
}
