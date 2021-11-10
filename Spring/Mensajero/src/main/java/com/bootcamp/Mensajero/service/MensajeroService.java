package com.bootcamp.Mensajero.service;

import com.bootcamp.Mensajero.dto.MensajeDTO;
import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.mapper.IMensajeroMapper;
import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.repository.IMensajeroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MensajeroService implements IMensajeroService {

    IMensajeroRepository mensajeroRepository;
    IMensajeroMapper mensajeroMapper;

    public MensajeroService(IMensajeroRepository mensajeroRepository, IMensajeroMapper mensajeroMapper) {
        this.mensajeroRepository = mensajeroRepository;
        this.mensajeroMapper = mensajeroMapper;
    }

    @Override
    public List<MensajeroDTO> getMensajeros() {
        Map<Long, Mensajero> mensajeros = mensajeroRepository.listarMensajeros();
        ArrayList<MensajeroDTO> mensajerosList = new ArrayList();
        return mensajeros.keySet().stream()
                .map(k -> mensajeroMapper.mensajeroToManesajeroDTO(mensajeros.get(k),k))
                .collect(Collectors.toList());
    }

    @Override
    public MensajeDTO getMensaje(long mensajeroId, String mensaje) {
        return new MensajeDTO(mensajeroRepository.getMensajero(mensajeroId).emitirMensaje(mensaje));
    }
}
