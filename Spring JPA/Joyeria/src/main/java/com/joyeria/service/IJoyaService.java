package com.joyeria.service;

import com.joyeria.dto.JoyaDto;
import com.joyeria.dto.JoyaIdDto;

import java.util.List;

public interface IJoyaService {
    JoyaIdDto addJoya(JoyaDto dto);
    List<JoyaIdDto> getAllJoyas();
}
