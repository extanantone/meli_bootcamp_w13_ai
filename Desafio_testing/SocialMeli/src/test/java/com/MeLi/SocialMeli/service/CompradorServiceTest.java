package com.MeLi.SocialMeli.service;

import com.MeLi.SocialMeli.DTO.InfoSeguidosDTO;
import com.MeLi.SocialMeli.DTO.SeguimientoDTO;
import com.MeLi.SocialMeli.DTO.VendedorDTO;
import com.MeLi.SocialMeli.controller.CompradorController;
import com.MeLi.SocialMeli.exception.NotFoundCompradorException;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.mapper.VendedorMapper;
import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Vendedor;
import com.MeLi.SocialMeli.repository.CompradorRepositoryImplement;
import com.MeLi.SocialMeli.repository.VendedorRepositoryImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CompradorServiceTest {

    //@Mock
    //private CompradorServiceImplement mockCompradorService;

    @Mock
    private CompradorRepositoryImplement mockCompradorRepository;

    @Mock
    private VendedorRepositoryImplement mockVendedorRepository;

    @InjectMocks
    private CompradorService compradorService;

    @Test
    void if_follow_is_success() throws NotFoundVendedorException, NotFoundCompradorException {

        //arrange
        Comprador comprador = new Comprador(1,"Pedro");
        Vendedor vendedor = new Vendedor(3,"Juan");

        //mock
        Mockito.when(mockCompradorRepository.find(1)).thenReturn(Optional.of(comprador));
        Mockito.when(mockVendedorRepository.find(3)).thenReturn(Optional.of(vendedor));

        //act
        SeguimientoDTO resultado = compradorService.seguir(1,3);

        //assert
        assertEquals("Seguimiento exitoso", resultado.getMsj());
    }

    @Test
    void if_follower_not_exist_follow() throws NotFoundVendedorException, NotFoundCompradorException {

        //act
        Mockito.when(mockCompradorRepository.find(5)).thenReturn(Optional.empty());

        //assert
        Assertions.assertThrows(NotFoundCompradorException.class, ()->compradorService.seguir(5,3));
    }

    @Test
    void if_followed_not_exist_follow() throws NotFoundVendedorException, NotFoundCompradorException {

        //arrange
        Comprador comprador = new Comprador(1,"Pedro");

        //mock
        Mockito.when(mockCompradorRepository.find(1)).thenReturn(Optional.of(comprador));
        Mockito.when(mockVendedorRepository.find(1)).thenReturn(Optional.empty());

        //assert
        Assertions.assertThrows(NotFoundVendedorException.class, ()->compradorService.seguir(1,1));
    }


    @Test
    void if_unfollow_is_success() throws NotFoundVendedorException, NotFoundCompradorException {

        //arrange
        Comprador comprador = new Comprador(1,"Pedro");
        Vendedor vendedor = new Vendedor(3,"Juan");

        //mock
        Mockito.when(mockCompradorRepository.find(1)).thenReturn(Optional.of(comprador));
        Mockito.when(mockVendedorRepository.find(3)).thenReturn(Optional.of(vendedor));

        //act
        SeguimientoDTO resultado = compradorService.dejarSeguir(1,3);

        //assert
        assertEquals(comprador.getNombre() + " has dejado de seguir a " + vendedor.getNombre(), resultado.getMsj());
    }

    @Test
    void if_unfollowed_not_exist() throws NotFoundVendedorException, NotFoundCompradorException{

        //arrange
        Comprador comprador = new Comprador(1,"Pedro");

        //mock
        Mockito.when(mockCompradorRepository.find(1)).thenReturn(Optional.of(comprador));
        Mockito.when(mockVendedorRepository.find(1)).thenReturn(Optional.empty());

        //assert
        Assertions.assertThrows(NotFoundVendedorException.class, ()->compradorService.dejarSeguir(1,1));
    }

    @Test
    void ordenamiento() throws NotFoundVendedorException, NotFoundCompradorException {
        //arrange
        Comprador comprador = new Comprador(1,"Pedro");
        Vendedor vendedor = new Vendedor(3,"Juan");
        comprador.setSeguido(vendedor);

        //mock
        Mockito.when(mockCompradorRepository.find(1)).thenReturn(Optional.of(comprador));
        Mockito.when(mockVendedorRepository.find(3)).thenReturn(Optional.of(vendedor));

        //act
        InfoSeguidosDTO seguidos = compradorService.verSeguidos(1,"");
        List<VendedorDTO> listaEsperada = new ArrayList<>();
        listaEsperada.add(VendedorMapper.vendedorToVendedorDTO(vendedor));
        InfoSeguidosDTO dtoEsperado = new InfoSeguidosDTO(comprador.getId(),comprador.getNombre(),listaEsperada);

        //assert
        assertEquals(dtoEsperado,seguidos);
    }

}
