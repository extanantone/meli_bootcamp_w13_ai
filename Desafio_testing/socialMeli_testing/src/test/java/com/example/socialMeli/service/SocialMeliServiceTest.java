package com.example.socialMeli.service;

import com.example.socialMeli.dto.RespuestaSimpleDTO;
import com.example.socialMeli.exceptions.UsuarioNoEncontradoError;
import com.example.socialMeli.model.Comprador;
import com.example.socialMeli.model.Vendedor;
import com.example.socialMeli.repository.ISocialMeliRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

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
        Boolean flag=true;
        Vendedor vende = new Vendedor("vendedor 1", 3);
        Comprador compra = new Comprador("comprador 1", 1);
        RespuestaSimpleDTO expected= new RespuestaSimpleDTO("El comprador "+compra.getUser_id()+" ha seguido con exito al vendedor "+vende.getUser_id(), 200);
        when(repo.buscarVendedor(vende.getUser_id())).thenReturn(vende);
        when(repo.buscarComprador(compra.getUser_id())).thenReturn(compra);
        when(repo.buscarSeguidor(vende.getSeguidores(), compra.getUser_id())).thenReturn(null);
        when(repo.seguir(compra,vende)).thenReturn(flag=true);

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
        Boolean flag=true;
        Vendedor vende = new Vendedor("vendedor 1", 3);
        Comprador compra = new Comprador("comprador 1", 1);
        RespuestaSimpleDTO expected= new RespuestaSimpleDTO("El comprador "+compra.getUser_id()+" ha dejado de seguir con exito al vendedor "+vende.getUser_id(), 200);
        when(repo.buscarVendedor(vende.getUser_id())).thenReturn(vende);
        when(repo.buscarComprador(compra.getUser_id())).thenReturn(compra);
        when(repo.buscarSeguidor(vende.getSeguidores(), compra.getUser_id())).thenReturn(compra);
        when(repo.dejarDeSeguir(compra,vende)).thenReturn(flag=true);

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
}
