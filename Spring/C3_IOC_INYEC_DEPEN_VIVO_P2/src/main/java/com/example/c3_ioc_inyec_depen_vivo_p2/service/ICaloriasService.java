package com.example.c3_ioc_inyec_depen_vivo_p2.service;

import com.example.c3_ioc_inyec_depen_vivo_p2.dto.CaloriasDTO;
import com.example.c3_ioc_inyec_depen_vivo_p2.model.Ingrediente;
import com.example.c3_ioc_inyec_depen_vivo_p2.model.Plato;

import java.util.List;
import java.util.Map;

public interface ICaloriasService
{
    public List<CaloriasDTO> calcularParametros(List<Plato> plato);
}
