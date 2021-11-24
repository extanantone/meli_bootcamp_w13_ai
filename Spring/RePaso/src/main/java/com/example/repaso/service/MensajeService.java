package com.example.repaso.service;

import com.example.repaso.dto.MensajeDTO;
import com.example.repaso.dto.MensajeroDTO;
import com.example.repaso.mapper.MensajeroMapper;
import com.example.repaso.repository.IMensajeRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensajeService implements IMensajeService
{
    @Autowired
    IMensajeRepository mensajeRepository;

    @Autowired
    MensajeroMapper mensajeroMapper;

    @Override
    public List<MensajeroDTO> listMensajeros()
    {
        return mensajeRepository.mensajeroMap().values().stream().map((x) -> mensajeroMapper.mensajeroToMensajeroDTO(x)).collect(Collectors.toList());
    }

    @Override
    public MensajeDTO getMessage(Long id)
    {
        return null;
    }
}
