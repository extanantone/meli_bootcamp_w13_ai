package com.bootcamp.Mensajero.service;

import com.bootcamp.Mensajero.dto.MensajeDTO;
import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.dto.MensajeroTipoDTO;
import com.bootcamp.Mensajero.exception.NotFoundMensajeroException;
import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.repository.IMensajeroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MensajeroService implements IMensajeroService{
    IMensajeroRepository mensajeroRepository;

    ModelMapper mapper = new ModelMapper();

    public MensajeroService(IMensajeroRepository mensajeroRepository) {
        this.mensajeroRepository = mensajeroRepository;
    }

    @Override
    public MensajeDTO retornarMensaje(Long id, String msj)
            throws NotFoundMensajeroException {
        Mensajero mensajero = mensajeroRepository.find(id)
                .orElseThrow(() ->
                        new NotFoundMensajeroException( id ));

        return new MensajeDTO(id, mensajero.emitirMensaje(msj) );
    }

    @Override
    public MensajeroTipoDTO retornarMensajero(Long id)
            throws NotFoundMensajeroException {

        Mensajero mensajero = mensajeroRepository.find(id)
                .orElseThrow(() ->
                        new NotFoundMensajeroException( id ));

        return mapper.map(mensajero, MensajeroTipoDTO.class);
    }

    @Override
    public List<MensajeroDTO> listarMensajeros() {
        Set<Map.Entry<Long, Mensajero>> entries = mensajeroRepository.findAll();

        List<MensajeroDTO> rets = new ArrayList<>();

        for (Map.Entry<Long, Mensajero> entry:
             entries) {
            rets.add( new MensajeroDTO(
                    entry.getKey(),
                    entry.getValue().getType() ) );
        }

        return rets;
    }
}
