package com.bootcamp.EJREPMessengers.service;

import com.bootcamp.EJREPMessengers.dto.AMensajeroDTO;
import com.bootcamp.EJREPMessengers.mapper.MensajeroMapper;
import com.bootcamp.EJREPMessengers.repository.IMensajeroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensajeroService implements IMensajeroService {
    IMensajeroRepository iMensajeroRepository;
    MensajeroMapper mensajeroMapper;
    ModelMapper modelMapper;

    public MensajeroService(IMensajeroRepository iMensajeroRepository, MensajeroMapper mensajeroMapper, ModelMapper modelMapper) {
        this.iMensajeroRepository = iMensajeroRepository;
        this.mensajeroMapper = mensajeroMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AMensajeroDTO> devolverMensajeros() {
        return iMensajeroRepository.buscarMensajeros()
                .stream()
                .map(aMensajero -> mensajeroMapper.mensajeroAMensajeroDTO(aMensajero))
                .collect(Collectors.toList());
    }

    @Override
    public String devolverMensaje(AMensajeroDTO aMensajeroDTO) {
        return iMensajeroRepository
                .buscarMensajero(mensajeroMapper
                        .mensajeroDTOAMensajero(aMensajeroDTO.getTipoMensajero(),aMensajeroDTO));
    }
}
