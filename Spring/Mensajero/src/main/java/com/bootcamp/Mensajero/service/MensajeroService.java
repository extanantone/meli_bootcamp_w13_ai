package com.bootcamp.Mensajero.service;

import com.bootcamp.Mensajero.dto.MensajeDTO;
import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.repository.IMensajeroRepository;
import com.bootcamp.Mensajero.exception.MensajeroNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MensajeroService implements IMensajeroService {
    IMensajeroRepository mensajeroRepository;

    public MensajeroService(IMensajeroRepository mensajeroRepository){
        this.mensajeroRepository = mensajeroRepository;
    }

    @Override
    public MensajeDTO retornarMensaje(Long idMensajero, String mensajeCustom) {
        Mensajero mensajero = mensajeroRepository.find(idMensajero)
                .orElseThrow(() ->
                        new MensajeroNotFoundException(idMensajero));
        return new MensajeDTO(idMensajero, mensajero.emitirMensaje(mensajeCustom));
    }

    @Override
    public List<MensajeroDTO> listarMensajeros() {
        Set<Map.Entry<Long, Mensajero>> entries = mensajeroRepository.listarMensajeros();

        List<MensajeroDTO> listaDeMensajeros = new ArrayList<>();
        for (Map.Entry<Long, Mensajero> entry:
            entries) {
            listaDeMensajeros.add(
                            new MensajeroDTO(entry.getKey(),
                            entry.getValue().getTipo()));
        }
        return listaDeMensajeros;
    }
}
