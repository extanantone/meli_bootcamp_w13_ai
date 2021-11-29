package com.socialmeli.demo.test.serviceTest;


import com.socialmeli.demo.dto.*;
import com.socialmeli.demo.exceptions.Error;
import com.socialmeli.demo.model.Comprador;
import com.socialmeli.demo.model.Producto;
import com.socialmeli.demo.model.Vendedor;
import com.socialmeli.demo.util.TestUtilGenerator;
import com.socialmeli.demo.repository.ISocialRepository;
import com.socialmeli.demo.service.SocialService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.fail;

@ExtendWith(MockitoExtension.class)
public class TestService {

    //Given
    @Mock
    ISocialRepository repo;
    //----Repository

    @InjectMocks
    SocialService service;

    //----Service
    private void setUp(){

    }
    @Test
    void T_0001_1() throws Error, Error {
        // arrange
        //Given
        Comprador comprador;
        comprador= new Comprador("comprador 1", 1);
        Vendedor vendedor;
        vendedor = new Vendedor("vendedor 1", 3);
        
        RespuestaDTO expected= new RespuestaDTO("El comprador "+comprador.getUser_id()+" sigue al vendedor"+vendedor.getUser_id(), 200);
        when(repo.buscarVendedor(vendedor.getUser_id())).thenReturn(vendedor);
        when(repo.buscarComprador(comprador.getUser_id())).thenReturn(comprador);
        when(repo.buscarSeguidor(vendedor.getSeguidores(), comprador.getUser_id())).thenReturn(null);
        when(repo.seguir(comprador,vendedor)).thenReturn(true);
        //when
        // act
        RespuestaDTO actual = service.follow(comprador.getUser_id(), vendedor.getUser_id());
        //then
        // assert
        verify(repo, atLeastOnce()).buscarVendedor(vendedor.getUser_id());
        assertAll("rta", () -> assertEquals(expected.getStatusCode(), actual.getStatusCode()),
                () -> assertEquals(expected.getMensaje(), actual.getMensaje()));
    }
    @Test
    void T_0001_2() throws Error {
        // arrange
        Vendedor vendedor = new Vendedor("vendedor 1", 3);
        Comprador comprador;
        comprador = new Comprador("comprador 1", 1);
        when(repo.buscarVendedor(vendedor.getUser_id())).thenReturn(null);
        when(repo.buscarComprador(comprador.getUser_id())).thenReturn(comprador);

        // assert

        assertThrows(Error.class,()->service.follow(comprador.getUser_id(), vendedor.getUser_id()));
        verify(repo, atLeastOnce()).buscarVendedor(vendedor.getUser_id());
    }
    @Test
    void T_0002_1() throws Error {
        // arrange
        Vendedor vendedor = new Vendedor("vendedor 1", 3);
        Comprador comprador;
        comprador = new Comprador("comprador 1", 1);
        RespuestaDTO expected= new RespuestaDTO("El comprador "+comprador.getUser_id()+" ha dejado de seguir con exito al vendedor "+vendedor.getUser_id(), 200);
        when(repo.buscarVendedor(vendedor.getUser_id())).thenReturn(vendedor);
        when(repo.buscarComprador(comprador.getUser_id())).thenReturn(comprador);
        when(repo.buscarSeguidor(vendedor.getSeguidores(), comprador.getUser_id())).thenReturn(comprador);
        when(repo.unfollow(comprador,vendedor)).thenReturn(true);

        // act
        RespuestaDTO actual = service.unfollow(comprador.getUser_id(), vendedor.getUser_id());

        // assert
        verify(repo, atLeastOnce()).buscarVendedor(vendedor.getUser_id());
        assertAll("rta", () -> assertEquals(expected.getStatusCode(), actual.getStatusCode()),
                () -> assertEquals(expected.getMensaje(), actual.getMensaje()));
    }
    @Test
    void T_0002_2() throws Error {
        // arrange
        Vendedor vendedor = new Vendedor("vendedor 1", 3);
        Comprador comprador = new Comprador("comprador 1", 1);
        when(repo.buscarVendedor(vendedor.getUser_id())).thenReturn(null);
        when(repo.buscarComprador(comprador.getUser_id())).thenReturn(comprador);

        // assert
        assertThrows(Error.class,()->service.unfollow(comprador.getUser_id(), vendedor.getUser_id()));
        verify(repo, atLeastOnce()).buscarVendedor(vendedor.getUser_id());
    }


    @Test
    void T_0003_1() throws Error {
        // arrange
        Vendedor vendedor = new Vendedor("vendedor 1", 3);
        CompradoresDTO comprador = new CompradoresDTO(21, "Zamara");
        CompradoresDTO compra2 = new CompradoresDTO(22, "Andrea");
        List<CompradoresDTO> compradores = new ArrayList<>();
        compradores.add(compra2);
        compradores.add(comprador);
        SeguidoresDTO expected = new SeguidoresDTO(vendedor.getUser_id(),vendedor.getName(), compradores);
        vendedor.getSeguidores().add(new Comprador(comprador.getUser_name(), comprador.getUser_id()));
        vendedor.getSeguidores().add(new Comprador(compra2.getUser_name(), compra2.getUser_id()));
        when(repo.buscarVendedor(vendedor.getUser_id())).thenReturn(vendedor);
        // act
        SeguidoresDTO actual = service.buscarSeguidores(vendedor.getUser_id(), "name_asc");
        List<CompradoresDTO> compradoresActual = actual.getFollowers();

        // assert
        verify(repo, atLeastOnce()).buscarVendedor(vendedor.getUser_id());
        assertEquals(2,compradoresActual.size());
    }

    @Test
     void T_0003_2() throws Error {
        // arrange
        // arrange
        Vendedor vendedor = new Vendedor("vendedor 1", 3);
        CompradoresDTO comprador = new CompradoresDTO(21, "Zamara");
        CompradoresDTO compra2 = new CompradoresDTO(22, "Andrea");
        List<CompradoresDTO> compradores = new ArrayList<>();
        compradores.add(compra2);
        compradores.add(comprador);
        SeguidoresDTO expected = new SeguidoresDTO(vendedor.getUser_id(),vendedor.getName(), compradores);
        vendedor.getSeguidores().add(new Comprador(comprador.getUser_name(), comprador.getUser_id()));
        vendedor.getSeguidores().add(new Comprador(compra2.getUser_name(), compra2.getUser_id()));
        when(repo.buscarVendedor(vendedor.getUser_id())).thenReturn(vendedor);
        // assert
        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> service.buscarSeguidores(vendedor.getUser_id(), null));
    }
    @Test
    void T_0004_1() throws Error {
        // arrange

        Vendedor vendedor = new Vendedor("vendedor 1", 3);
        CompradoresDTO comprador = new CompradoresDTO(21, "Zamara");
        CompradoresDTO compra2 = new CompradoresDTO(22, "Andrea");
        List<CompradoresDTO> compradores = new ArrayList<>();
        compradores.add(compra2);
        compradores.add(comprador);
        SeguidoresDTO expected = new SeguidoresDTO(vendedor.getUser_id(),vendedor.getName(), compradores);
        vendedor.getSeguidores().add(new Comprador(comprador.getUser_name(), comprador.getUser_id()));
        vendedor.getSeguidores().add(new Comprador(compra2.getUser_name(), compra2.getUser_id()));
        when(repo.buscarVendedor(vendedor.getUser_id())).thenReturn(vendedor);

        // act
        SeguidoresDTO actual = service.buscarSeguidores(vendedor.getUser_id(), "name_asc");
        List<CompradoresDTO> compradoresActual = actual.getFollowers();
        // assert
        verify(repo, atLeastOnce()).buscarVendedor(vendedor.getUser_id());
        assertAll("seguidores", () -> assertEquals(compradores.get(0).getUser_id(), compradoresActual.get(0).getUser_id()),
                () -> assertEquals(compradores.get(0).getUser_name(),compradores.get(0).getUser_name()),
                () -> assertEquals(compradores.get(1).getUser_id(), compradoresActual.get(1).getUser_id()),
                () -> assertEquals(compradores.get(1).getUser_name(),compradores.get(1).getUser_name()));
    }

    @Test
    void T_0004_2() throws Error {
        // arrange
        Comprador comprador = new Comprador("comprador 1", 1);
        CompradoresDTO vendedor = new CompradoresDTO(23, "Ximena");
        CompradoresDTO vende2 = new CompradoresDTO(24, "Camilo");

        List<CompradoresDTO> vendedores = new ArrayList<>();
        vendedores.add(vende2);
        vendedores.add(vendedor);
        SeguidoresDTO expected = new SeguidoresDTO(comprador.getUser_id(),comprador.getName(), vendedores);
        comprador.getSiguiendo().add(new Vendedor(vendedor.getUser_name(), vendedor.getUser_id()));
        comprador.getSiguiendo().add(new Vendedor(vende2.getUser_name(), vende2.getUser_id()));
        when(repo.buscarComprador(comprador.getUser_id())).thenReturn(comprador);

        // act
        SeguidoresDTO actual = service.buscarSeguidos(comprador.getUser_id(), "name_asc");
        List<CompradoresDTO> vendedoresActual = actual.getFollowers();
        // assert
        verify(repo, atLeastOnce()).buscarComprador(comprador.getUser_id());
        assertAll("seguidos", () -> assertEquals(vendedores.get(0).getUser_id(), vendedoresActual.get(0).getUser_id()),
                () -> assertEquals(vendedores.get(0).getUser_name(),vendedores.get(0).getUser_name()),
                () -> assertEquals(vendedores.get(1).getUser_id(), vendedoresActual.get(1).getUser_id()),
                () -> assertEquals(vendedores.get(1).getUser_name(),vendedores.get(1).getUser_name()));
    }

    @Test
    void T_0004_3() throws Error {
        // arrange

        Vendedor vendedor = new Vendedor("vendedor 1", 3);
        CompradoresDTO comprador = new CompradoresDTO(21, "Zamara");
        CompradoresDTO compra2 = new CompradoresDTO(22, "Andrea");
        List<CompradoresDTO> compradores = new ArrayList<>();
        compradores.add(comprador);
        compradores.add(compra2);
        SeguidoresDTO expected = new SeguidoresDTO(vendedor.getUser_id(),vendedor.getName(), compradores);
        vendedor.getSeguidores().add(new Comprador(comprador.getUser_name(), comprador.getUser_id()));
        vendedor.getSeguidores().add(new Comprador(compra2.getUser_name(), compra2.getUser_id()));
        when(repo.buscarVendedor(vendedor.getUser_id())).thenReturn(vendedor);

        // act
        SeguidoresDTO actual = service.buscarSeguidores(vendedor.getUser_id(), "name_desc");
        List<CompradoresDTO> compradoresActual = actual.getFollowers();
        // assert
        verify(repo, atLeastOnce()).buscarVendedor(vendedor.getUser_id());
        assertAll("seguidores", () -> assertEquals(compradores.get(0).getUser_id(), compradoresActual.get(0).getUser_id()),
                () -> assertEquals(compradores.get(0).getUser_name(),compradores.get(0).getUser_name()),
                () -> assertEquals(compradores.get(1).getUser_id(), compradoresActual.get(1).getUser_id()),
                () -> assertEquals(compradores.get(1).getUser_name(),compradores.get(1).getUser_name()));
    }

    @Test
    void T_0004_4() throws Error {
        // arrange
        Comprador comprador = new Comprador("comprador 1", 1);
        CompradoresDTO vendedor = new CompradoresDTO(23, "Ximena");
        CompradoresDTO vende2 = new CompradoresDTO(24, "Camilo");
        List<CompradoresDTO> vendedores = new ArrayList<>();
        vendedores.add(vendedor);
        vendedores.add(vende2);
        SeguidoresDTO expected = new SeguidoresDTO(comprador.getUser_id(),comprador.getName(), vendedores);
        comprador.getSiguiendo().add(new Vendedor(vendedor.getUser_name(), vendedor.getUser_id()));
        comprador.getSiguiendo().add(new Vendedor(vende2.getUser_name(), vende2.getUser_id()));
        when(repo.buscarComprador(comprador.getUser_id())).thenReturn(comprador);

        // act
        SeguidoresDTO actual = service.buscarSeguidos(comprador.getUser_id(), "name_desc");
        List<CompradoresDTO> vendedoresActual = actual.getFollowers();
        // assert
        verify(repo, atLeastOnce()).buscarComprador(comprador.getUser_id());
        assertAll("seguidos", () -> assertEquals(vendedores.get(0).getUser_id(), vendedoresActual.get(0).getUser_id()),
                () -> assertEquals(vendedores.get(0).getUser_name(),vendedores.get(0).getUser_name()),
                () -> assertEquals(vendedores.get(1).getUser_id(), vendedoresActual.get(1).getUser_id()),
                () -> assertEquals(vendedores.get(1).getUser_name(),vendedores.get(1).getUser_name()));
    }

    @Test
    void T_0005_1() throws Error {
        // arrange
        TestUtilGenerator prueba = new TestUtilGenerator();
        Comprador comprador = prueba.ordenamiento();
        when(repo.buscarComprador(comprador.getUser_id())).thenReturn(comprador);
        // act
        List<VendedoresDTO> actual = service.addPublicaciones(comprador.getUser_id(), "date_desc");
        // assert
        verify(repo, atLeastOnce()).buscarComprador(comprador.getUser_id());
        //System.out.println(actual.size());
        assertEquals(2,actual.size());
    }

    @Test
    void T_0005_2() throws Error {
        // arrange
        TestUtilGenerator prueba = new TestUtilGenerator();
        Comprador comprador = prueba.ordenamiento();
        when(repo.buscarComprador(comprador.getUser_id())).thenReturn(comprador);
        // assert

        assertThrows(NullPointerException.class, ()->service.addPublicaciones(comprador.getUser_id(), null));
    }

    @Test
    void T_0006_1() throws Error {
        // arrange
        TestUtilGenerator prueba = new TestUtilGenerator();
        List<String> fechas = prueba.devolverFechas();
        Comprador comprador = prueba.ordenamiento();
        Vendedor vendedor = new Vendedor("Ximena",23);

        ProductoDTO prodDto = new ProductoDTO(1,"silla","gamer", "pollito","negro","nada");
        PublicacionDTO pub1 = new PublicacionDTO(23,1, fechas.get(0),prodDto,100, 10000,false,0);

        when(repo.buscarComprador(comprador.getUser_id())).thenReturn(comprador);
        when(repo.buscarVendedor(vendedor.getUser_id())).thenReturn(vendedor);
        when(repo.buscarPost(vendedor.getPublicaciones(),pub1.getId_post())).thenReturn(null);

        // act
        service.addPost(pub1);
        List<VendedoresDTO> actual = service.addPublicaciones(comprador.getUser_id(), "date_asc");
        // assert
        verify(repo, atLeastOnce()).buscarComprador(comprador.getUser_id());
        assertAll("posts", () -> assertEquals(fechas.get(0), actual.get(0).getPosts().get(0).getDate()),
                () -> assertEquals(fechas.get(1),actual.get(1).getPosts().get(0).getDate()));
    }
    @Test
    void T_0006_2() throws Error {
        // arrange
        TestUtilGenerator prueba = new TestUtilGenerator();
        List<String> fechas = prueba.fechasOrdenadas();
        Comprador comprador = prueba.ordenamiento();
        when(repo.buscarComprador(comprador.getUser_id())).thenReturn(comprador);
        Producto prod = new Producto(1,"silla","gamer", "pollito","negro","nada");

        // act
        List<VendedoresDTO> actual = service.addPublicaciones(comprador.getUser_id(), "date_desc");
        // assert
        verify(repo, atLeastOnce()).buscarComprador(comprador.getUser_id());
        assertAll("posts", () -> assertEquals(fechas.get(0), actual.get(0).getPosts().get(0).getDate()),
                () -> assertEquals(fechas.get(1),actual.get(1).getPosts().get(0).getDate()));
    }
    @Test
    void T_0007_1() throws Error {
        // arrange
        FollowsDTO expected = new FollowsDTO(3, "vendedor 1", 1) ;
        Vendedor vendedor = new Vendedor("vendedor 1", 3);
        Comprador comprador = new Comprador("comprador 1", 1);
        when(repo.buscarVendedor(vendedor.getUser_id())).thenReturn(vendedor);
        vendedor.getSeguidores().add(comprador);
        // act
        FollowsDTO actual = service.contar(vendedor.getUser_id());

        // assert
        assertAll("rta", () -> assertEquals(expected.getUser_id(), actual.getUser_id()),
                () -> assertEquals(expected.getFollowers_count(), actual.getFollowers_count()));
    }

    @Test
    void T_0008_1() throws Error {
        // arrange
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        TestUtilGenerator prueba = new TestUtilGenerator();
        Comprador comprador = prueba.ordenamientoPost();
        when(repo.buscarComprador(comprador.getUser_id())).thenReturn(comprador);

        // act
        List<VendedoresDTO> actual = service.addPublicaciones(comprador.getUser_id(), "date_asc");
        // assert
        LocalDate fechaAct = LocalDate.parse(actual.get(0).getPosts().get(0).getDate(), formatter);
        verify(repo, atLeastOnce()).buscarComprador(comprador.getUser_id());
        assertAll("posts", () -> assertEquals(true, service.validarFecha(fechaAct)),
                () -> assertEquals(1,actual.get(0).getPosts().size()),
                () -> assertEquals(1,actual.size()));
    }


}
