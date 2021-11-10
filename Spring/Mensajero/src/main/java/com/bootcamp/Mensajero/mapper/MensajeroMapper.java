package com.bootcamp.Mensajero.mapper;

import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.model.Mensajero;
import org.springframework.stereotype.Component;


@Component
public class MensajeroMapper implements IMensajeroMapper{
    @Override
    public MensajeroDTO mensajeroToManesajeroDTO(Mensajero mensajero, long id) {
        String[] classStringArray = mensajero.getClass().toString().split("\\.");
        return new MensajeroDTO(id,
                classStringArray[classStringArray.length-1],
                mensajero.getPlantilla());
    }
}
