package com.example.c3_ioc_inyec_depen_vivo_p2.service;

import com.example.c3_ioc_inyec_depen_vivo_p2.model.Ingrediente;
import com.example.c3_ioc_inyec_depen_vivo_p2.model.Plato;

import java.util.Map;

public interface ICaloriasService
{
    public int consulCalorias(Plato plato);

    public Map<String, Integer> ingredientesCals(Plato plato);

    public Ingrediente ingredienteMaxCal(Plato plato);
}
