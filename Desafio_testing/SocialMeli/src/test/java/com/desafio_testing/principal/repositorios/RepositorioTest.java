package com.desafio_testing.principal.repositorios;


import com.desafio_testing.principal.enumerados.EnumErrs;
import com.desafio_testing.principal.excepciones.NegocioException;
import com.desafio_testing.principal.modelo.Producto;
import com.desafio_testing.principal.modelo.Publicacion;
import com.desafio_testing.principal.modelo.Usuario;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class RepositorioTest {

    @Autowired
    private static Repositorio repo;
    private static Usuario usuarioTest1;
    private static Usuario usuarioTest2;


    @BeforeAll
    private static void inicializar(){
        repo = new Repositorio();
        usuarioTest1 = repo.findUserById(1);
        usuarioTest2 = repo.findUserById(2);
    }

    @Test
    public void findUserHappy(){

        //Arrange
        String nombreEsperado = "Roman";
        //Act
        Usuario current = repo.findUserById(1);
        //Assertions
        Assertions.assertEquals(nombreEsperado,current.getUserName());
    }

    @Test
    public void verifyRepoUserSadT0001(){
        //Arrange
        Usuario user1 = new Usuario(6,"2");
        Usuario user2 = new Usuario(7,"11");
        //Act
        //Aseetions
        NegocioException salida = Assertions.assertThrows(NegocioException.class,()->repo.registrarSeguidor(user1,user2), EnumErrs.NOT_FOUND.getMensaje());
        Assertions.assertEquals(EnumErrs.NOT_FOUND.getCodigo(),salida.getCodigo());
    }

    @Test
    public void verifyRepoUserHappyT0001(){
        //Arrange
        //Act
        repo.registrarSeguidor(usuarioTest1,usuarioTest2);
    }

    @Test
    public void verifyUnfollowUserExistSadT0002(){
        //Arrange
        Usuario user1 = new Usuario(6,"2");
        Usuario user2 = new Usuario(7,"11");
        //Act
        //Assertions
        NegocioException salida = Assertions.assertThrows(NegocioException.class,()->repo.quitarSeguidor(user1,user2), EnumErrs.NOT_FOUND.getMensaje());
        Assertions.assertEquals(EnumErrs.NOT_FOUND.getCodigo(),salida.getCodigo());
    }

    @Nested
    class TestNestUnfollowUserHappyT0002{

        @BeforeEach
        public void initTest(){
            repo = new Repositorio();
            repo.registrarSeguidor(usuarioTest1,usuarioTest2);
        }

        @Test
        public void verifyUnfollowUserExistHappyNestT0002(){
            //Arrange
            //Act
            //Aseetions
            repo.quitarSeguidor(usuarioTest1,usuarioTest2);
        }

    }

    @Test
    public void verifyUnfollowUserExistHappyT0002(){
        //Arrange
        //Act
        //Aseetions
        NegocioException salida = Assertions.assertThrows(NegocioException.class,()->repo.quitarSeguidor(usuarioTest1,usuarioTest2));
        Assertions.assertEquals(EnumErrs.NOT_FOLLOWED.getCodigo(),salida.getCodigo());
    }

    @Test
    public void verifyUnfollowUserNotFollowerHappyT00X1(){
        //Arrange
        //Act
        //Aseetions
        NegocioException salida = Assertions.assertThrows(NegocioException.class,()->repo.quitarSeguidor(usuarioTest1,usuarioTest2));
        Assertions.assertEquals(EnumErrs.NOT_FOLLOWED.getCodigo(),salida.getCodigo());
    }


    @Nested
    class VerifyCorrectCountT0008{

        @BeforeEach
        public void initTest() {
            repo = new Repositorio();
            repo.registrarSeguidor(usuarioTest1, usuarioTest2);
            repo.crearPublicacion(new Publicacion(1, LocalDate.now(), new Producto(3, "Silla Gamer2", "Gamer4", "Racer4", "Red & Black4", "Special Edition4"), 100, 1500.5, usuarioTest1, false, 0.0));
            repo.crearPublicacion(new Publicacion(2, LocalDate.now(), new Producto(3, "Silla Gamer2", "Gamer4", "Racer4", "Red & Black4", "Special Edition4"), 100, 1500.5, usuarioTest1, false, 0.0));
            repo.crearPublicacion(new Publicacion(3, LocalDate.now(), new Producto(3, "Silla Gamer2", "Gamer4", "Racer4", "Red & Black4", "Special Edition4"), 100, 1500.5, usuarioTest1, false, 0.0));
            repo.crearPublicacion(new Publicacion(4, LocalDate.now(), new Producto(3, "Silla Gamer2", "Gamer4", "Racer4", "Red & Black4", "Special Edition4"), 100, 1500.5, usuarioTest1, false, 0.0));
            repo.crearPublicacion(new Publicacion(5, LocalDate.now().minusDays(28), new Producto(3, "Silla Gamer2", "Gamer4", "Racer4", "Red & Black4", "Special Edition4"), 100, 1500.5, usuarioTest1, false, 0.0));
        }

        @Test
        public void verifyDateCorrectT0008(){
            //Arrange
            //Act
            //Aseetions
            LocalDate fechaActual = LocalDate.now();

            List<Publicacion> lista = repo.publicacionesParaSeguidor(usuarioTest2,fechaActual.minusDays(14));

            Assertions.assertEquals(4,lista.size());
        }

    }




}
