package com.bootcamp.c1p1Joyeria.service;

import com.bootcamp.c1p1Joyeria.dto.JoyaDTO;
import com.bootcamp.c1p1Joyeria.model.Joya;
import com.bootcamp.c1p1Joyeria.repository.JoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService {
    JoyaRepository joyaRepository;
    ModelMapper mapper = new ModelMapper();

    public JoyaService(JoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public Long saveJoya(JoyaDTO joyaDTO) {
        joyaRepository.save(mapper.map(joyaDTO, Joya.class));
        return joyaDTO.getNroIdentificatorio();
    }

    @Override
    public List<JoyaDTO> getAllJoyas() {
        return joyaRepository.findAll()
                .stream()
                .map(joya -> mapper.map(joya, JoyaDTO.class))
                .filter(joyaDTO -> joyaDTO.getVentaONo())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteJoya(Long nroIdentificatorio) {
        JoyaDTO joyaDTO = mapper.map(joyaRepository.getById(nroIdentificatorio), JoyaDTO.class);
        joyaDTO.setVentaONo(false);
        joyaRepository.save(mapper.map(joyaDTO, Joya.class));
    }

    @Override
    public JoyaDTO updateJoya(JoyaDTO joyaDTO, Long nroIdentificatorio) {
        joyaDTO.setNroIdentificatorio(nroIdentificatorio);
        joyaRepository.save(mapper.map(joyaDTO, Joya.class));
        return joyaDTO;
    }
}
