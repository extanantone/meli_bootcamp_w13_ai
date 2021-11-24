package com.example.repaso.controller;

import com.example.repaso.dto.MensajeDTO;
import com.example.repaso.dto.MensajeroDTO;
import com.example.repaso.model.Mensajero;
import com.example.repaso.service.IMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MensajeController implements IMensajeController
{
    @Autowired
    IMensajeService mensajeService;

    @Override
    public List<MensajeroDTO> mensajerosList()
    {
        return mensajeService.listMensajeros();
    }

    @Override
    public MensajeDTO mensaje(Long id)
    {
        return mensajeService.getMessage(id);
    }
}
