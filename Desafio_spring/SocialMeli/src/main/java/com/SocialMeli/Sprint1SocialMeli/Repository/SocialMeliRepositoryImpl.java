package com.SocialMeli.Sprint1SocialMeli.Repository;

import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Model.Usuario;
import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class SocialMeliRepositoryImpl implements ISocialMeliRepository {

    Map<Integer, Comprador> compradores;
    Map<Integer, Vendedor> vendedores;

    public SocialMeliRepositoryImpl() {

        this.compradores = new HashMap<>();
        this.vendedores = new HashMap<>();
        compradores.put(1,new Comprador(1,"juan525c"));
        compradores.put(2,new Comprador(2,"andres747c"));
        compradores.put(3,new Comprador(3,"brian8474c"));
        vendedores.put(4,new Vendedor(4,"Lucas323v"));
        vendedores.put(5,new Vendedor(5,"David323v"));

    }

    @Override
    public boolean follow(Integer id_comprador, Integer id_vendedor) {



        if(compradores.containsKey(id_comprador) || vendedores.containsKey(id_vendedor))
        {return false;}
        else{
            Comprador comprador = compradores.get(id_comprador);
            comprador.addFollowed(id_vendedor);

            Vendedor vendedor = vendedores.get(id_vendedor);
            vendedor.addFollower(id_comprador);

            return true;
        }

    }

    @Override
    public boolean unFollow(Integer id_Comprador, Integer id_vendedor) {
        return false;
    }

    @Override
    public List<Comprador> vendedorFollowers(Integer id_vendedor) {
        return null;
    }

    @Override
    public List<Vendedor> compradorFollowed(Integer id_comprador) {
        return null;
    }

    @Override
    public boolean newPost(Integer id_venderdor, Publicacion publicacion) {
        return false;
    }

    @Override
    public List<Publicacion> postByVendedorOfComprador(Integer id_comprador) {
        return null;
    }

    @Override
    public List<Comprador> vendedorFollowersOrderByName(Integer id_vendedor, String orden) {
        return null;
    }

    @Override
    public List<Vendedor> compradorFollowedOrderByName(Integer id_comprador, String orden) {
        return null;
    }

    @Override
    public List<Publicacion> postByVendedorOfCompradorOrderByDate(Integer id_comprador, String orden) {
        return null;
    }

    @Override
    public Comprador getComprador(Integer id_comprador) {
         return compradores.get(id_comprador);
    }

    @Override
    public Vendedor getVendedor(Integer id_vendedor) {
        return vendedores.get(id_vendedor);
    }
}
