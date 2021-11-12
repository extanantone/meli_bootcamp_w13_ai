package com.example.socialmeli.demo.repository;


import com.example.socialmeli.demo.model.Comprador;

public interface ICompradorRepository {

    public Comprador crearComprador(Comprador c);

    public Comprador obtenerCompradorPorID(int id);

}
