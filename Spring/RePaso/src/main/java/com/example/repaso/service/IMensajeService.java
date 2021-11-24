package com.example.repaso.service;

import com.example.repaso.dto.MensajeDTO;
import com.example.repaso.dto.MensajeroDTO;

import java.util.List;

public interface IMensajeService
{
    List<MensajeroDTO> listMensajeros();

    MensajeDTO getMessage(Long id);
}
