package com.SocialMeli.Sprint1SocialMeli.Repository;

import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class SocialMeliRepositoryImpl implements ISocialMeliRepository {

    Map<Integer, Comprador> compradores;
    Map<Integer, Vendedor> vendedores;

    public SocialMeliRepositoryImpl() {

        this.compradores = new HashMap<>();
        this.vendedores = new HashMap<>();
        compradores.put(1, new Comprador(1, "juan525c"));
        compradores.put(2, new Comprador(2, "andres747c"));
        compradores.put(3, new Comprador(3, "brian8474c"));
        vendedores.put(4, new Vendedor(4, "Lucas323v"));
        vendedores.put(5, new Vendedor(5, "David323v"));

    }

    @Override
    public boolean follow(Integer compradorId, Integer vendedorId) {

        if (compradores.containsKey(compradorId) || vendedores.containsKey(vendedorId)) {

            Comprador comprador = compradores.get(compradorId);
            comprador.addFollowed(vendedorId);
            Vendedor vendedor = vendedores.get(vendedorId);
            vendedor.addFollower(compradorId);
            return true;

        } else {

            return false;

        }

    }

    @Override
    public boolean unFollow(Integer compradorID, Integer vendedorId) {
        return false;
    }


    // Revisar si es util antes de entregar
    @Override
    public List<Comprador> vendedorFollowersList(List<Integer> followerIds) {

        List<Comprador> compradorList = followerIds.stream()
                .map(f -> compradores.get(f))
                .collect(Collectors.toList());

        return compradorList;
    }

    @Override
    public List<Vendedor> compradorFollowed(Integer compradorID) {
        return null;
    }

    @Override
    public boolean newPost(Integer venderdorId, Publicacion publicacion) {


        List<Publicacion> publicacions = new ArrayList<>();
        publicacions.add(publicacion);
        vendedores.get(venderdorId).setPosts(publicacions);
        return true;
    }

    @Override
    public List<Publicacion> postByVendedorOfComprador(Integer compradorID) {
        return null;
    }

    @Override
    public List<Comprador> vendedorFollowersOrderByName(Integer vendedorId, String orden) {

        return null;
    }

    @Override
    public List<Vendedor> compradorFollowedOrderByName(Integer compradorID, String orden) {
        return null;
    }

    @Override
    public List<Publicacion> postByVendedorOfCompradorOrderByDate(Integer compradorID, String orden) {
        return null;
    }

    @Override
    public Comprador getComprador(Integer compradorId) {
        return compradores.get(compradorId);
    }

    @Override
    public Vendedor getVendedor(Integer vendedorId) {
        return vendedores.get(vendedorId);
    }

    @Override
    public Boolean existsFollow(Integer compradorId, Integer vendedorId) {

        Comprador comprador = getComprador(compradorId);
        Boolean resp1 = comprador.getFolloweds().stream()
                .anyMatch(c -> c.equals(vendedorId));

        return resp1;
    }

    @Override
    public Boolean existPost(Integer vendedorId, Integer postId) {

        boolean resp = vendedores.get(vendedorId)
                .getPosts()
                .stream()
                .anyMatch(ven -> ven.getPostId() == postId);


        return resp;
    }


}
