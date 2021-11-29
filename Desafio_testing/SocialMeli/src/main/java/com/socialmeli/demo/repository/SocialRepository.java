package com.socialmeli.demo.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.demo.model.Comprador;
import com.socialmeli.demo.model.Publicacion;
import com.socialmeli.demo.model.Vendedor;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Getter
@Repository
public class SocialRepository implements ISocialRepository {
    List<Comprador> compradores;
    List<Vendedor> vendedores;
    List<Publicacion> publicacion;

    @Override
    public boolean post(Vendedor vende, Publicacion post){
        vende.getPublicaciones().add(post);
        this.publicacion.add(post);
        return true;
    }
    @Override
    public boolean unfollow(Comprador compra, Vendedor vende){
        vende.getSeguidores().remove(compra);
        compra.getSiguiendo().remove(vende);
        return true;
    }
    @Override
    public List<Vendedor> ListaVendedores() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:vendedores.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Vendedor>> typeRef = new TypeReference<>() {};
        List<Vendedor> vendedores = null;
        try {
            vendedores = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendedores;
    }

    @Override
    public List<Comprador> ListaCompradores() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:compradores.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Comprador>> typeRef = new TypeReference<>() {};
        List<Comprador> compradores = null;
        try {
            compradores = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compradores;
    }

    @Override
    public void addVendedores() {
        this.vendedores = ListaVendedores();
        for (Vendedor v: this.vendedores) {
            v.setSeguidores(new ArrayList<Comprador>());
            v.setPublicaciones(new ArrayList<Publicacion>());
        }
        this.publicacion = new ArrayList<>();
    }

    @Override
    public void addCompradores() {
        this.compradores = ListaCompradores();
        for (Comprador c: this.compradores) {
            c.setSiguiendo(new ArrayList<Vendedor>());
        }
    }

    @Override
    public Comprador buscarComprador(Integer id) {
        return this.compradores.stream().filter(p -> p.getUser_id() == id).findFirst().orElse(null);
    }

    @Override
    public Vendedor buscarVendedor(Integer id) {
        return this.vendedores.stream().filter(p -> p.getUser_id() == id).findFirst().orElse(null);
    }

    @Override
    public Comprador buscarSeguidor(List<Comprador>seguidores, Integer idComprador){
        return seguidores.stream().filter(p -> p.getUser_id() == idComprador).findFirst().orElse(null);
    }
    @Override
    public List<Publicacion> retornarPublicaciones(){
        return this.publicacion;
    }
    @Override
    public Publicacion buscarPost(List<Publicacion> publi, Integer idPub) {
        return publi.stream().filter(p -> p.getId_publicacion() == idPub).findFirst().orElse(null);
    }
    @Override
    public boolean seguir (Comprador compra, Vendedor vende){
        vende.getSeguidores().add(compra);
        compra.getSiguiendo().add(vende);
        return true;
    }
    @Override
    public void imprimirSeguidores (Vendedor vende){
        Integer i=0;
        for (Comprador c: vende.getSeguidores()) {
            System.out.println(c.getName());
            System.out.println(i++);
        }
    }

}
