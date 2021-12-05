package com.bootcamp.c1p1Joyeria.service;

import com.bootcamp.c1p1Joyeria.dto.JoyaDTO;

import java.util.List;

public interface IJoyaService {
    Long saveJoya(JoyaDTO joyaDTO);

    List<JoyaDTO> getAllJoyas();

    void deleteJoya(Long nroIdentificatorio);

    JoyaDTO updateJoya(JoyaDTO joyaDTO, Long nroIdentificatorio);
}
