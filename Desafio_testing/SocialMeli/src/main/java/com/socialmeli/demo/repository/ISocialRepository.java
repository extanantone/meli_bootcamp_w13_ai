package com.socialmeli.demo.repository;


import com.socialmeli.demo.model.Comprador;
import com.socialmeli.demo.model.Publicacion;
import com.socialmeli.demo.model.Vendedor;

import java.util.List;

public interface ISocialRepository {

    //Add usuarios
    public void addVendedores();
    public void addCompradores();
    //Buscar
    public Comprador buscarComprador(Integer id);
    public Vendedor buscarVendedor(Integer id);
    public Comprador buscarSeguidor(List<Comprador>seguidores, Integer idComprador);
    public Publicacion buscarPost(List<Publicacion> publi, Integer idPub);

    //Operaciones
    public boolean seguir (Comprador compra, Vendedor vende);
    public boolean post(Vendedor vende, Publicacion post);
    public boolean unfollow(Comprador compra, Vendedor vende);


    public List<Vendedor> ListaVendedores();
    public List<Comprador> ListaCompradores();
    public List<Publicacion> retornarPublicaciones();
    public void imprimirSeguidores (Vendedor vende);
}
