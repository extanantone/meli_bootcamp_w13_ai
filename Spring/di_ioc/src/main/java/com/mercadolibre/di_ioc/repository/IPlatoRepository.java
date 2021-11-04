package com.mercadolibre.di_ioc.repository;

import com.mercadolibre.di_ioc.model.Ingrediente;

import java.util.List;

public interface IPlatoRepository {
    public List<Ingrediente> abrirIngredienteJSON();
}
