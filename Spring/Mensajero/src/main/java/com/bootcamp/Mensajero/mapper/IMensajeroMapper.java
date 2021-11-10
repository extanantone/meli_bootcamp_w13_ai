package com.bootcamp.Mensajero.mapper;

import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.model.Mensajero;

public interface IMensajeroMapper {
    public MensajeroDTO mensajeroToManesajeroDTO(Mensajero mensajero, long id);
}
