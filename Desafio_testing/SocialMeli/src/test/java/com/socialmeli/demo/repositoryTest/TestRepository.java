package com.socialmeli.demo.repositoryTest;

import com.socialmeli.demo.model.Comprador;
import com.socialmeli.demo.model.Publicacion;
import com.socialmeli.demo.model.Vendedor;
import com.socialmeli.demo.repository.ISocialRepository;
import com.socialmeli.demo.repository.SocialRepository;
import com.socialmeli.demo.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRepository {
    ISocialRepository repo;
    @BeforeEach @AfterEach
    void setup(){
        //Configuracion inical
        this.repo = new SocialRepository();
        repo.addCompradores();
        repo.addVendedores();
    }


    //busqueda de usuarios
    @Test
    void usuarioValido(){
        Comprador compradorEsperado;

        compradorEsperado= new Comprador("comprador 1", 1);
        Comprador compradorActual;
        compradorActual=repo.buscarComprador(compradorEsperado.getUser_id());
        assertAll("comprador", () -> assertEquals(compradorEsperado.getName(), compradorActual.getName()),
                () -> assertEquals(compradorEsperado.getUser_id(), compradorActual.getUser_id()));
    }
    @Test
    void usuarioNoValido(){
        Comprador compradorActual;
        compradorActual=repo.buscarComprador(60);
        assertEquals(null,compradorActual);
    }
    //Busqueda de seguidores
    @Test
    void seguidorValido(){
        //comprador de prueba
        Comprador comprador;
        comprador= new Comprador("comprador 1", 1);
        //vendedor de prueba
        Vendedor vendedor;
        vendedor= new Vendedor("vendedor 1",3);


        repo.seguir(comprador,vendedor);
        List<Comprador> expected;
        expected = vendedor.getSeguidores();
        Comprador actual;
        actual = repo.buscarSeguidor(expected, comprador.getUser_id());
        assertAll("seguidor", () -> assertEquals(comprador.getName(), actual.getName()),
                () -> assertEquals(comprador.getUser_id(), actual.getUser_id()));
    }
    @Test
    void seguidorNoValido(){
        //vendedor de prueba
        Vendedor vendedor;
        vendedor= new Vendedor("vendedor 1",3);
        //comprador de prueba
        Comprador comprador;
        comprador= new Comprador("comprador 1", 2);
        repo.seguir(comprador,vendedor);
        List<Comprador> expected = vendedor.getSeguidores();
        Comprador actual = repo.buscarSeguidor(expected, 1);
        assertEquals(null, actual );
    }

    @Test
    void toPost(){
        TestUtilGenerator utiles = new TestUtilGenerator();
        //vendedor de prueba
        Vendedor vendedor;
        vendedor= new Vendedor("vendedor 1",3);
        Publicacion publicacion;
        publicacion = utiles.postPrueba();
        Boolean flag = repo.post(vendedor, publicacion);
        assertAll("seguidor", () -> assertEquals(true, flag),
                () -> assertEquals(1, vendedor.getPublicaciones().size()));
    }

    @Test
    void unFollow(){
        
        //vendedor de prueba
        Comprador comprador;
        comprador = new Comprador("comprador 1", 2);
        //comprador de prueba
        Vendedor vendedor;
        vendedor = new Vendedor("vendedor 1",3);
        
        repo.seguir(comprador,vendedor);
        Boolean flag = repo.unfollow(comprador, vendedor);
        List<Vendedor> siguiendo = comprador.getSiguiendo();
        List<Comprador> seguidores = vendedor.getSeguidores();
        assertAll("noSeguidor", () -> assertEquals(true, flag),
                () -> assertEquals(0, siguiendo.size()),
                () -> assertEquals(0, seguidores.size()));
    }
    @Test
    void searchPost(){
        TestUtilGenerator utiles = new TestUtilGenerator();
        Vendedor vendedor;
        vendedor = new Vendedor("vendedor 1",3);
        Publicacion publicacion;
        publicacion = utiles.postPrueba();
        vendedor.getPublicaciones().add(publicacion);
        Publicacion actual;
        actual = repo.buscarPost(vendedor.getPublicaciones(),publicacion.getId_publicacion());
        assertAll("post", () -> assertEquals(publicacion.getId_publicacion(), actual.getId_publicacion()),
                () -> assertEquals(publicacion.getId_user(), publicacion.getId_user()));
    }
    @Test
    void Valido(){
        Vendedor vendedorEsperado;
        vendedorEsperado = new Vendedor("vendedor 1", 3);
        Vendedor vendedorActual;
        vendedorActual=repo.buscarVendedor(vendedorEsperado.getUser_id());
        assertAll("vendedor", () -> assertEquals(vendedorEsperado.getName(), vendedorActual.getName()),
                () -> assertEquals(vendedorEsperado.getUser_id(), vendedorActual.getUser_id()));
    }
    @Test
    void NoValido(){
        Vendedor vendedorActual;
        vendedorActual=repo.buscarVendedor(60);

        assertEquals(null,vendedorActual);
    }
}
