package com.joyeria.service;

import com.joyeria.dto.JoyaDto;
import com.joyeria.dto.JoyaIdDto;
import com.joyeria.mapper.JoyaMapper;
import com.joyeria.model.Joya;
import com.joyeria.repository.JoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private JoyaRepository joyaRepository;

    private JoyaMapper joyaMapper;

    public JoyaService(JoyaRepository joyaRepository,JoyaMapper joyaMapper){
        this.joyaRepository = joyaRepository;
        this.joyaMapper = joyaMapper;
    }

    @Override
    public JoyaIdDto addJoya(JoyaDto dto) {
        Joya joya = joyaMapper.getJoya(dto);
        return joyaMapper.getJoyaIdDto(joyaRepository.save(joya));
    }

    @Override
    public List<JoyaIdDto> getAllJoyas() {
        return joyaRepository.findAll().stream()
                .map(j->joyaMapper.getJoyaIdDto(j)).collect(Collectors.toList());
    }
}
