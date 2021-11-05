package com.ftbr.calculadoradecalorias.service;

import com.ftbr.calculadoradecalorias.dto.PlatoDTO;
import com.ftbr.calculadoradecalorias.dto.PlatoRequestDTO;

import java.util.List;

public interface IPlatoService {
    public PlatoDTO calcuarCalorias(PlatoRequestDTO platoRequest);
    public List<PlatoDTO> calcuarCaloriasLista(List<PlatoRequestDTO> platosRequest);
}
