package com.example.c3_ioc_inyec_depen_vivo_p2.repository;

import com.example.c3_ioc_inyec_depen_vivo_p2.model.Ingrediente;
import com.example.c3_ioc_inyec_depen_vivo_p2.model.Plato;

import java.util.List;
import java.util.Map;

public interface ICaloriasRepository
{
    public List<Ingrediente> ingredientesList();

    public Map<String, Integer> ingredientesDict();
}
