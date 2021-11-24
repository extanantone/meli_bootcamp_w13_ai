package com.bootcamp.calculadorDeCalorias.service;

import com.bootcamp.calculadorDeCalorias.dto.InfoPlatoDTO;
import com.bootcamp.calculadorDeCalorias.dto.PlatoDTO;

public interface IPlatoService {
    public InfoPlatoDTO getInfoPlato(PlatoDTO inPlato);

}
