package com.example.socialMeli.repository;

import com.example.socialMeli.exceptions.UsuarioNoEncontradoError;
import com.example.socialMeli.model.Comprador;
import com.example.socialMeli.model.Publicacion;
import com.example.socialMeli.model.Vendedor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SocialMeliRepository implements  ISocialMeliRepository{
    List<Comprador> compradores;
    List<Vendedor> vendedores;
    List<Publicacion> publicaciones;
    @Override
    public List<Vendedor> abrirJsonVendedores() {
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
    public List<Comprador> abrirJsonCompradores() {
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
    public void agregarVendedores() {
        this.vendedores = abrirJsonVendedores();
        for (Vendedor v: this.vendedores) {
            v.setSeguidores(new ArrayList<Comprador>());
        }
    }

    @Override
    public void agregarCompradores() {
        this.compradores = abrirJsonCompradores();
        for (Comprador c: this.compradores) {
            c.setSiguiendo(new ArrayList<Vendedor>());
        }
    }

    @Override
    public Comprador buscarComprador(int id) {
        return this.compradores.stream().filter(p -> p.getUser_id() == id).findFirst().orElse(null);
    }

    @Override
    public Vendedor buscarVendedor(int id) {
        return this.vendedores.stream().filter(p -> p.getUser_id() == id).findFirst().orElse(null);
    }

    @Override
    public Publicacion buscarPublicacion(int id) {
        return this.publicaciones.stream().filter(p -> p.getId_publicacion() == id).findFirst().orElse(null);
    }
    @Override
    public Comprador buscarSeguidor(List<Comprador>seguidores, int idComprador){
        return seguidores.stream().filter(p -> p.getUser_id() == idComprador).findFirst().orElse(null);
    }
    @Override
    public boolean seguir (Comprador compra, Vendedor vende){
        return vende.getSeguidores().add(compra);
    }
    @Override
    public void imprimirSeguidores (Vendedor vende){
        int i=0;
        for (Comprador c: vende.getSeguidores()) {
            System.out.println(c.getName());
            System.out.println(i++);
        }
    }
}
