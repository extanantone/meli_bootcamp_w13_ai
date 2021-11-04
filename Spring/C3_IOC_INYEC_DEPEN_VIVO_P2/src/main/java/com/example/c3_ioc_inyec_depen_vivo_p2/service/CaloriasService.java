package com.example.c3_ioc_inyec_depen_vivo_p2.service;

import com.example.c3_ioc_inyec_depen_vivo_p2.model.Ingrediente;
import com.example.c3_ioc_inyec_depen_vivo_p2.model.Plato;
import com.example.c3_ioc_inyec_depen_vivo_p2.repository.ICaloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CaloriasService implements ICaloriasService
{
    @Autowired
    ICaloriasRepository caloriasRepository;

    @Override
    public int consulCalorias(Plato plato)
    {
        return 0;
    }

    @Override
    public Map<String, Integer> ingredientesCals(Plato plato)
    {
        return null;
    }

    @Override
    public Ingrediente ingredienteMaxCal(Plato plato)
    {
        return null;
    }
}
