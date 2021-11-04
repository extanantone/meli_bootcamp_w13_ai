package com.c3spring.ejercicio.ejerciciosTarde.Repository;

import com.c3spring.ejercicio.ejerciciosTarde.model.Ingrediente;

import java.util.List;

public interface IRepositorio {
    public List<Ingrediente> leerArchivo();
    public List<Ingrediente> obtenerLista();

}
