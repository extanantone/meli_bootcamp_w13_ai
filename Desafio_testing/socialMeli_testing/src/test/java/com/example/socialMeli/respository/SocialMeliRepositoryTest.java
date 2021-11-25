package com.example.socialMeli.respository;

import com.example.socialMeli.model.Comprador;
import com.example.socialMeli.model.Publicacion;
import com.example.socialMeli.model.Vendedor;
import com.example.socialMeli.repository.ISocialMeliRepository;
import com.example.socialMeli.repository.SocialMeliRepository;
import com.example.socialMeli.service.SocialMeliService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
