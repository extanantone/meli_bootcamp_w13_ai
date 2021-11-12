package com.example.socialMeli.repository;

import com.example.socialMeli.model.Comprador;
import com.example.socialMeli.model.Publicacion;
import com.example.socialMeli.model.Vendedor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public interface ISocialMeliRepository {
    public List<Vendedor> abrirJsonVendedores();
    public List<Comprador> abrirJsonCompradores();
    public void agregarVendedores();
    public void agregarCompradores();
    public Comprador buscarComprador(int id);
    public Vendedor buscarVendedor(int id);
    public Comprador buscarSeguidor(List<Comprador>seguidores, int idComprador);
    public Publicacion buscarPost(List<Publicacion> publi, int idPub);
    public boolean seguir (Comprador compra, Vendedor vende);
    public void imprimirSeguidores (Vendedor vende);
    public boolean postear (Vendedor vende, Publicacion post);
    public boolean dejarDeSeguir (Comprador compra, Vendedor vende);
    public List<Publicacion> retornarPublicaciones();
}
