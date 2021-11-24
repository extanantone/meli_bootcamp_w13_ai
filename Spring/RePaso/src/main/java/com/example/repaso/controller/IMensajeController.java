package com.example.repaso.controller;

import com.example.repaso.dto.MensajeDTO;
import com.example.repaso.dto.MensajeroDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("api/v1/mensajes")
public interface IMensajeController
{
    @GetMapping
    List<MensajeroDTO> mensajerosList();

    @GetMapping("/{id}")
    MensajeDTO mensaje(@PathVariable Long id);
}
