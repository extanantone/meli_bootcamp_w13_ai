package com.example.socialMeli.service;

import com.example.socialMeli.dto.*;
import com.example.socialMeli.exceptions.UsuarioNoEncontradoError;
import com.example.socialMeli.model.Comprador;
import com.example.socialMeli.model.Producto;
import com.example.socialMeli.model.Publicacion;
import com.example.socialMeli.model.Vendedor;
import com.example.socialMeli.repository.ISocialMeliRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {
    @Mock
    ISocialMeliRepository repo;

    @InjectMocks
    SocialMeliService service;

    @Test
    void T_0001_cumple() throws UsuarioNoEncontradoError {
        // arrange
        Vendedor vende = new Vendedor("vendedor 1", 3);
        Comprador compra = new Comprador("comprador 1", 1);
        RespuestaSimpleDTO expected= new RespuestaSimpleDTO("El comprador "+compra.getUser_id()+" ha seguido con exito al vendedor "+vende.getUser_id(), 200);
        when(repo.buscarVendedor(vende.getUser_id())).thenReturn(vende);
        when(repo.buscarComprador(compra.getUser_id())).thenReturn(compra);
        when(repo.buscarSeguidor(vende.getSeguidores(), compra.getUser_id())).thenReturn(null);
        when(repo.seguir(compra,vende)).thenReturn(true);

        // act
        RespuestaSimpleDTO actual = service.seguir(compra.getUser_id(), vende.getUser_id());

        // assert
        verify(repo, atLeastOnce()).buscarVendedor(vende.getUser_id());
        assertAll("rta", () -> assertEquals(expected.getStatusCode(), actual.getStatusCode()),
                () -> assertEquals(expected.getMensaje(), actual.getMensaje()));
    }

    @Test
    void T_0001_NoCumple() throws UsuarioNoEncontradoError {
        // arrange
        Vendedor vende = new Vendedor("vendedor 1", 3);
        Comprador compra = new Comprador("comprador 1", 1);
        when(repo.buscarVendedor(vende.getUser_id())).thenReturn(null);
        when(repo.buscarComprador(compra.getUser_id())).thenReturn(compra);

        // assert

        assertThrows(UsuarioNoEncontradoError.class,()->service.seguir(compra.getUser_id(), vende.getUser_id()));
        verify(repo, atLeastOnce()).buscarVendedor(vende.getUser_id());
    }

    @Test
    void T_0002_cumple() throws UsuarioNoEncontradoError {
        // arrange
        Vendedor vende = new Vendedor("vendedor 1", 3);
        Comprador compra = new Comprador("comprador 1", 1);
        RespuestaSimpleDTO expected= new RespuestaSimpleDTO("El comprador "+compra.getUser_id()+" ha dejado de seguir con exito al vendedor "+vende.getUser_id(), 200);
        when(repo.buscarVendedor(vende.getUser_id())).thenReturn(vende);
        when(repo.buscarComprador(compra.getUser_id())).thenReturn(compra);
        when(repo.buscarSeguidor(vende.getSeguidores(), compra.getUser_id())).thenReturn(compra);
        when(repo.dejarDeSeguir(compra,vende)).thenReturn(true);

        // act
        RespuestaSimpleDTO actual = service.dejarDeSeguir(compra.getUser_id(), vende.getUser_id());

        // assert
        verify(repo, atLeastOnce()).buscarVendedor(vende.getUser_id());
        assertAll("rta", () -> assertEquals(expected.getStatusCode(), actual.getStatusCode()),
                () -> assertEquals(expected.getMensaje(), actual.getMensaje()));
    }
    @Test
    void T_0002_NoCumple() throws UsuarioNoEncontradoError {
        // arrange
        Vendedor vende = new Vendedor("vendedor 1", 3);
        Comprador compra = new Comprador("comprador 1", 1);
        when(repo.buscarVendedor(vende.getUser_id())).thenReturn(null);
        when(repo.buscarComprador(compra.getUser_id())).thenReturn(compra);

        // assert
        assertThrows(UsuarioNoEncontradoError.class,()->service.dejarDeSeguir(compra.getUser_id(), vende.getUser_id()));
        verify(repo, atLeastOnce()).buscarVendedor(vende.getUser_id());
    }
    @Test
    void T_0004_ascFollowers() throws UsuarioNoEncontradoError {
        // arrange

        Vendedor vende = new Vendedor("vendedor 1", 3);
        CompradoresDTO compra = new CompradoresDTO(21, "Zamara");
        CompradoresDTO compra2 = new CompradoresDTO(22, "Andrea");
        List<CompradoresDTO> compradores = new ArrayList<>();
        compradores.add(compra2);
        compradores.add(compra);
        SeguidoresDTO expected = new SeguidoresDTO(vende.getUser_id(),vende.getName(), compradores);
        vende.getSeguidores().add(new Comprador(compra.getUser_name(), compra.getUser_id()));
        vende.getSeguidores().add(new Comprador(compra2.getUser_name(), compra2.getUser_id()));
        when(repo.buscarVendedor(vende.getUser_id())).thenReturn(vende);

        // act
        SeguidoresDTO actual = service.buscarSeguidores(vende.getUser_id(), "name_asc");
        List<CompradoresDTO> compradoresActual = actual.getFollowers();
        // assert
        verify(repo, atLeastOnce()).buscarVendedor(vende.getUser_id());
        assertAll("seguidores", () -> assertEquals(compradores.get(0).getUser_id(), compradoresActual.get(0).getUser_id()),
                () -> assertEquals(compradores.get(0).getUser_name(),compradores.get(0).getUser_name()),
                () -> assertEquals(compradores.get(1).getUser_id(), compradoresActual.get(1).getUser_id()),
                () -> assertEquals(compradores.get(1).getUser_name(),compradores.get(1).getUser_name()));
    }

    @Test
    void T_0004_ascFollowed() throws UsuarioNoEncontradoError {
        // arrange
        Comprador compra = new Comprador("comprador 1", 1);
        CompradoresDTO vende = new CompradoresDTO(23, "Ximena");
        CompradoresDTO vende2 = new CompradoresDTO(24, "Camilo");

        List<CompradoresDTO> vendedores = new ArrayList<>();
        vendedores.add(vende2);
        vendedores.add(vende);
        SeguidosDTO expected = new SeguidosDTO(compra.getUser_id(),compra.getName(), vendedores);
        compra.getSiguiendo().add(new Vendedor(vende.getUser_name(), vende.getUser_id()));
        compra.getSiguiendo().add(new Vendedor(vende2.getUser_name(), vende2.getUser_id()));
        when(repo.buscarComprador(compra.getUser_id())).thenReturn(compra);

        // act
        SeguidosDTO actual = service.buscarSeguidos(compra.getUser_id(), "name_asc");
        List<CompradoresDTO> vendedoresActual = actual.getFollowed();
        // assert
        verify(repo, atLeastOnce()).buscarComprador(compra.getUser_id());
        assertAll("seguidos", () -> assertEquals(vendedores.get(0).getUser_id(), vendedoresActual.get(0).getUser_id()),
                () -> assertEquals(vendedores.get(0).getUser_name(),vendedores.get(0).getUser_name()),
                () -> assertEquals(vendedores.get(1).getUser_id(), vendedoresActual.get(1).getUser_id()),
                () -> assertEquals(vendedores.get(1).getUser_name(),vendedores.get(1).getUser_name()));
    }

    @Test
    void T_0004_descFollowers() throws UsuarioNoEncontradoError {
        // arrange

        Vendedor vende = new Vendedor("vendedor 1", 3);
        CompradoresDTO compra = new CompradoresDTO(21, "Zamara");
        CompradoresDTO compra2 = new CompradoresDTO(22, "Andrea");
        List<CompradoresDTO> compradores = new ArrayList<>();
        compradores.add(compra);
        compradores.add(compra2);
        SeguidoresDTO expected = new SeguidoresDTO(vende.getUser_id(),vende.getName(), compradores);
        vende.getSeguidores().add(new Comprador(compra.getUser_name(), compra.getUser_id()));
        vende.getSeguidores().add(new Comprador(compra2.getUser_name(), compra2.getUser_id()));
        when(repo.buscarVendedor(vende.getUser_id())).thenReturn(vende);

        // act
        SeguidoresDTO actual = service.buscarSeguidores(vende.getUser_id(), "name_desc");
        List<CompradoresDTO> compradoresActual = actual.getFollowers();
        // assert
        verify(repo, atLeastOnce()).buscarVendedor(vende.getUser_id());
        assertAll("seguidores", () -> assertEquals(compradores.get(0).getUser_id(), compradoresActual.get(0).getUser_id()),
                () -> assertEquals(compradores.get(0).getUser_name(),compradores.get(0).getUser_name()),
                () -> assertEquals(compradores.get(1).getUser_id(), compradoresActual.get(1).getUser_id()),
                () -> assertEquals(compradores.get(1).getUser_name(),compradores.get(1).getUser_name()));
    }

    @Test
    void T_0004_descFollowed() throws UsuarioNoEncontradoError {
        // arrange
        Comprador compra = new Comprador("comprador 1", 1);
        CompradoresDTO vende = new CompradoresDTO(23, "Ximena");
        CompradoresDTO vende2 = new CompradoresDTO(24, "Camilo");
        List<CompradoresDTO> vendedores = new ArrayList<>();
        vendedores.add(vende);
        vendedores.add(vende2);
        SeguidosDTO expected = new SeguidosDTO(compra.getUser_id(),compra.getName(), vendedores);
        compra.getSiguiendo().add(new Vendedor(vende.getUser_name(), vende.getUser_id()));
        compra.getSiguiendo().add(new Vendedor(vende2.getUser_name(), vende2.getUser_id()));
        when(repo.buscarComprador(compra.getUser_id())).thenReturn(compra);

        // act
        SeguidosDTO actual = service.buscarSeguidos(compra.getUser_id(), "name_desc");
        List<CompradoresDTO> vendedoresActual = actual.getFollowed();
        // assert
        verify(repo, atLeastOnce()).buscarComprador(compra.getUser_id());
        assertAll("seguidos", () -> assertEquals(vendedores.get(0).getUser_id(), vendedoresActual.get(0).getUser_id()),
                () -> assertEquals(vendedores.get(0).getUser_name(),vendedores.get(0).getUser_name()),
                () -> assertEquals(vendedores.get(1).getUser_id(), vendedoresActual.get(1).getUser_id()),
                () -> assertEquals(vendedores.get(1).getUser_name(),vendedores.get(1).getUser_name()));
    }
    @Test
    void T_0006_dateAsc() throws UsuarioNoEncontradoError {
        // arrange
        String date1= "14-11-2021";
        String date2= "20-11-2021";
        List<String> fechas = new ArrayList<>();
        fechas.add(date1);
        fechas.add(date2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha1 = LocalDate.parse(date1, formatter);
        LocalDate fecha2 = LocalDate.parse(date2, formatter);

        Comprador compra = new Comprador("comprador 1", 1);
        Vendedor vende = new Vendedor("Ximena",23);
        Vendedor vende2 = new Vendedor("Camilo",24);

        Producto prod = new Producto(1,"silla","gamer", "pollito","negro","nada");
        ProductoDTO prodDto = new ProductoDTO(1,"silla","gamer", "pollito","negro","nada");
        PublicacionDTO pub1 = new PublicacionDTO(23,1, date1,prodDto,100, 10000.0,false,0);
        vende.getPublicaciones().add(new Publicacion(23,1, fecha1,prod,100,10000,false,0));
        vende2.getPublicaciones().add(new Publicacion(24,12, fecha2,prod,100,10000,false,0));
        compra.getSiguiendo().add(vende);
        compra.getSiguiendo().add(vende2);
        Publicacion ejemplo = new Publicacion(23,1, fecha1,prod,100,10000,false,0);
        when(repo.buscarComprador(compra.getUser_id())).thenReturn(compra);
        when(repo.buscarVendedor(vende.getUser_id())).thenReturn(vende);
        when(repo.buscarPost(vende.getPublicaciones(),pub1.getId_post())).thenReturn(null);

        // act
        service.añadirPost(pub1);
        List<PublicacionesVendedoresDTO> actual = service.obtenerPublicaciones(compra.getUser_id(), "date_asc");
        // assert
        verify(repo, atLeastOnce()).buscarComprador(compra.getUser_id());
        assertAll("posts", () -> assertEquals(fechas.get(0), actual.get(0).getPosts().get(0).getDate()),
                () -> assertEquals(fechas.get(1),actual.get(1).getPosts().get(0).getDate()));
    }
    @Test
    void T_0006_dateDesc() throws UsuarioNoEncontradoError {
        // arrange
        String date1= "14-11-2021";
        String date2= "20-11-2021";
        List<String> fechas = new ArrayList<>();
        fechas.add(date2);
        fechas.add(date1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha1 = LocalDate.parse(date1, formatter);
        LocalDate fecha2 = LocalDate.parse(date2, formatter);

        Comprador compra = new Comprador("comprador 1", 1);
        Vendedor vende = new Vendedor("Ximena",23);
        Vendedor vende2 = new Vendedor("Camilo",24);

        when(repo.buscarComprador(compra.getUser_id())).thenReturn(compra);
        Producto prod = new Producto(1,"silla","gamer", "pollito","negro","nada");
        vende.getPublicaciones().add(new Publicacion(23,1, fecha1,prod,100,10000,false,0));
        vende2.getPublicaciones().add(new Publicacion(24,12, fecha2,prod,100,10000,false,0));
        compra.getSiguiendo().add(vende);
        compra.getSiguiendo().add(vende2);
        // act
        List<PublicacionesVendedoresDTO> actual = service.obtenerPublicaciones(compra.getUser_id(), "date_desc");
        // assert
        verify(repo, atLeastOnce()).buscarComprador(compra.getUser_id());
        assertAll("posts", () -> assertEquals(fechas.get(0), actual.get(0).getPosts().get(0).getDate()),
                () -> assertEquals(fechas.get(1),actual.get(1).getPosts().get(0).getDate()));
    }
    @Test
    void T_0007() throws UsuarioNoEncontradoError {
        // arrange
        CantidadFollowsDTO expected = new CantidadFollowsDTO(3, "vendedor 1", 1) ;
        Vendedor vende = new Vendedor("vendedor 1", 3);
        Comprador compra = new Comprador("comprador 1", 1);
        when(repo.buscarVendedor(vende.getUser_id())).thenReturn(vende);
        vende.getSeguidores().add(compra);
        // act
        CantidadFollowsDTO actual = service.contar(vende.getUser_id());

        // assert
        assertAll("rta", () -> assertEquals(expected.getUser_id(), actual.getUser_id()),
                () -> assertEquals(expected.getFollowers_count(), actual.getFollowers_count()));
    }

    @Test
    void T_0008() throws UsuarioNoEncontradoError {
        // arrange
        String date1= "14-10-2021";
        String date2= "20-11-2021";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha1 = LocalDate.parse(date1, formatter);
        LocalDate fecha2 = LocalDate.parse(date2, formatter);

        Comprador compra = new Comprador("comprador 1", 1);
        Vendedor vende = new Vendedor("Ximena",23);
        Vendedor vende2 = new Vendedor("Camilo",24);

        when(repo.buscarComprador(compra.getUser_id())).thenReturn(compra);
        Producto prod = new Producto(1,"silla","gamer", "pollito","negro","nada");
        ProductoDTO prodDto = new ProductoDTO(1,"silla","gamer", "pollito","negro","nada");
        vende.getPublicaciones().add(new Publicacion(23,1, fecha2,prod,100,10000,false,0));
        vende2.getPublicaciones().add(new Publicacion(24,12, fecha1,prod,100,10000,false,0));
        compra.getSiguiendo().add(vende);
        compra.getSiguiendo().add(vende2);

        // act
        List<PublicacionesVendedoresDTO> actual = service.obtenerPublicaciones(compra.getUser_id(), "date_asc");
        // assert
        LocalDate fechaAct = LocalDate.parse(actual.get(0).getPosts().get(0).getDate(), formatter);
        verify(repo, atLeastOnce()).buscarComprador(compra.getUser_id());
        assertAll("posts", () -> assertEquals(true, service.verificarVendedorYFecha(fechaAct)),
                () -> assertEquals(1,actual.get(0).getPosts().size()),
                () -> assertEquals(1,actual.size()));
    }
}
