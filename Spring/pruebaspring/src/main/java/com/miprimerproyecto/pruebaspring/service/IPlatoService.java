package com.miprimerproyecto.pruebaspring.service;

import com.miprimerproyecto.pruebaspring.dto.PlatoDTO;
import com.miprimerproyecto.pruebaspring.dto.PlatoDevueltoDTO;

import java.util.List;

public interface IPlatoService {

    PlatoDevueltoDTO getPlato (PlatoDTO platoDTO);
    List<PlatoDevueltoDTO> getPlatos ( List<PlatoDTO>  platoDTOs);
}
