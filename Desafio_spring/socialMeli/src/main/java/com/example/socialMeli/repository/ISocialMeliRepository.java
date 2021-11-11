package com.example.socialMeli.repository;

import com.example.socialMeli.model.Comprador;
import com.example.socialMeli.model.Publicacion;
import com.example.socialMeli.model.Vendedor;

import java.util.List;

public interface ISocialMeliRepository {
    public List<Vendedor> abrirJsonVendedores();
    public List<Comprador> abrirJsonCompradores();
    public void agregarVendedores();
    public void agregarCompradores();
    public Comprador buscarComprador(int id);
    public Vendedor buscarVendedor(int id);
    public Publicacion buscarPublicacion(int id);
    public Comprador buscarSeguidor(List<Comprador>seguidores, int idComprador);
    public boolean seguir (Comprador compra, Vendedor vende);
    public void imprimirSeguidores (Vendedor vende);
}
