package com.example.repaso.mapper;

import com.example.repaso.dto.MensajeroDTO;
import com.example.repaso.model.Mensajero;
import org.springframework.stereotype.Component;

@Component
public class MensajeroMapper
{
    public Mensajero mensajeroDTOToMensajero(MensajeroDTO mensajeroDTO)
    {
        return null;
    }

    public MensajeroDTO mensajeroToMensajeroDTO(Mensajero mensajero)
    {
        MensajeroDTO mensajeroDTO = new MensajeroDTO();
        mensajeroDTO.setType(mensajero.getType());
        mensajeroDTO.setId(mensajero.getId());
        return mensajeroDTO;
    }
}
