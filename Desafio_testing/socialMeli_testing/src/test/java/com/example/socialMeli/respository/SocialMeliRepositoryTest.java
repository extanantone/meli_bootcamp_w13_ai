package com.example.socialMeli.respository;

import com.example.socialMeli.model.Comprador;
import com.example.socialMeli.model.Publicacion;
import com.example.socialMeli.model.Vendedor;
import com.example.socialMeli.repository.ISocialMeliRepository;
import com.example.socialMeli.repository.SocialMeliRepository;
import com.example.socialMeli.service.SocialMeliService;
import com.example.socialMeli.utils.SocialMeliUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SocialMeliRepositoryTest {
    SocialMeliRepository repo;
    @BeforeEach
    void cargar(){
        this.repo = new SocialMeliRepository();
        repo.agregarCompradores();
        repo.agregarVendedores();
    }

    @Test
    void UsuarioASeguirYADejarDeSeguirValido(){
        Vendedor expected = new Vendedor("vendedor 1", 3);
        Vendedor actual=repo.buscarVendedor(expected.getUser_id());
        assertAll("vendedor", () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getUser_id(), actual.getUser_id()));
    }
    @Test
    void UsuarioASeguirYADejarDeSeguirNoValido(){
        Vendedor actual=repo.buscarVendedor(60);
        assertEquals(null,actual);
    }
    @Test
    void UsuarioCompradorValido(){
        Comprador expected = new Comprador("comprador 1", 1);
        Comprador actual=repo.buscarComprador(expected.getUser_id());
        assertAll("comprador", () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.getUser_id(), actual.getUser_id()));
    }
    @Test
    void UsuarioCompradorNoValido(){
        Comprador actual=repo.buscarComprador(60);
        assertEquals(null,actual);
    }

    @Test
    void buscarSeguidorValido(){
        Vendedor vende = new Vendedor("vendedor 1",3);
        Comprador compra = new Comprador("comprador 1", 1);

        repo.seguir(compra,vende);
        List<Comprador> expected = vende.getSeguidores();
        Comprador actual = repo.buscarSeguidor(expected, compra.getUser_id());
        assertAll("seguidor", () -> assertEquals(compra.getName(), actual.getName()),
                () -> assertEquals(compra.getUser_id(), actual.getUser_id()));
    }
    @Test
    void buscarSeguidorNoValido(){
        Vendedor vende = new Vendedor("vendedor 1",3);
        Comprador compra = new Comprador("comprador 1", 2);
        repo.seguir(compra,vende);
        List<Comprador> expected = vende.getSeguidores();
        Comprador actual = repo.buscarSeguidor(expected, 1);
        assertEquals(null, actual );
    }

    @Test
    void postear(){
        SocialMeliUtils utiles = new SocialMeliUtils();
        Vendedor vende = new Vendedor("vendedor 1",3);
        Publicacion pub = utiles.postQuemado();
        Boolean flag = repo.postear(vende, pub);
        assertAll("seguidor", () -> assertEquals(true, flag),
                () -> assertEquals(1, vende.getPublicaciones().size()));
    }

}
