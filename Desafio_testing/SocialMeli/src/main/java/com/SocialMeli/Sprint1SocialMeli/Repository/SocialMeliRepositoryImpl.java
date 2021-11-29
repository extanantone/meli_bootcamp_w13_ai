package com.SocialMeli.Sprint1SocialMeli.Repository;

import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.*;

@Getter
@Setter
@Repository
public class SocialMeliRepositoryImpl implements ISocialMeliRepository {

    Map<Integer, Comprador> compradores;
    Map<Integer, Vendedor> vendedores;
    List<Publicacion> publicaciones;

    public SocialMeliRepositoryImpl() {

        // Se crean Compradores y Vendedores
        this.compradores = new HashMap<>();
        this.vendedores = new HashMap<>();
        this.publicaciones = new ArrayList<>();
        compradores.put(1,new Comprador(1,"comprador1"));
        compradores.put(2,new Comprador(2,"comprador2"));

        vendedores.put(3,new Vendedor(3,"vendedor1"));
        vendedores.put(4,new Vendedor(4,"vendedor2"));


    }

    @Override
    public boolean follow(Integer id_comprador, Integer id_vendedor) {
            Comprador comprador = compradores.get(id_comprador);
            comprador.addFollowed(id_vendedor);

            Vendedor vendedor = vendedores.get(id_vendedor);
            vendedor.addFollower(id_comprador);
            return true;}

    @Override
    public boolean unFollow(Integer id_comprador, Integer id_vendedor) {

        Comprador comprador = compradores.get(id_comprador);
        comprador.deleteFollowed(id_vendedor);

        Vendedor vendedor = vendedores.get(id_vendedor);
        vendedor.deleteFollower(id_comprador);
        return true;}

    @Override
    public void newPost(Publicacion publicacion) {
        publicaciones.add(publicacion);
        // Ordeno por fecha las publicaciones. (Quedaron ordenadas en el service)
        //Collections.sort(publicaciones, (o1, o2) -> o2.getDate().compareTo(o1.getDate()));
            }

    @Override
    public Comprador getComprador(Integer id_comprador) {
         return compradores.get(id_comprador);
    }

    @Override
    public Vendedor getVendedor(Integer id_vendedor) {
        return vendedores.get(id_vendedor);
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }
}
