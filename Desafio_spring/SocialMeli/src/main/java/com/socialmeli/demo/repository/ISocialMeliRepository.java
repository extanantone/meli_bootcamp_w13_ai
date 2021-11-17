package com.socialmeli.demo.repository;


import com.socialmeli.demo.model.Comprador;
import com.socialmeli.demo.model.Publicacion;
import com.socialmeli.demo.model.Vendedor;

import java.util.List;

public interface ISocialMeliRepository {

    //Add usuarios
    public void addVendedores();
    public void addCompradores();
    //Buscar
    public Comprador buscarComprador(int id);
    public Vendedor buscarVendedor(int id);
    public Comprador buscarSeguidor(List<Comprador>seguidores, int idComprador);
    public Publicacion buscarPost(List<Publicacion> publi, int idPub);

    //Operaciones
    public boolean seguir (Comprador compra, Vendedor vende);
    public boolean post(Vendedor vende, Publicacion post);
    public boolean unfollow(Comprador compra, Vendedor vende);


    public List<Vendedor> ListaVendedores();
    public List<Comprador> ListaCompradores();
    public List<Publicacion> retornarPublicaciones();
    public void imprimirSeguidores (Vendedor vende);
}
