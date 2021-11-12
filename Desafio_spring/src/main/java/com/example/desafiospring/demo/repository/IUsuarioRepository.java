package com.example.desafiospring.demo.repository;

import com.example.desafiospring.demo.model.Usuarios;

public interface IVendedorRepository {

    public Usuarios crearVendedor(Usuarios v);

    public Usuarios obtenerVendedorPorID(int id);




}
