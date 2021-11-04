package com.c3.p2.service;

import com.c3.p2.dto.CaloriasDto;
import com.c3.p2.dto.PlatoDto;

import java.util.List;

public interface ICaloriasService {

    CaloriasDto calcularCaloriasPlato(PlatoDto plato);

    List<CaloriasDto> calcularCaloriasListaPlatos(List<PlatoDto> platosList);
}
