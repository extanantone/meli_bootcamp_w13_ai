package com.MeLi.SocialMeli.controller;

import com.MeLi.SocialMeli.DTO.SeguimientoDTO;
import com.MeLi.SocialMeli.exception.NotFoundCompradorException;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.repository.CompradorRepositoryImplement;
import com.MeLi.SocialMeli.service.CompradorServiceImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CompradorControllerTest {

    @Mock
    private CompradorServiceImplement mockCompradorService;

    @Mock
    private CompradorRepositoryImplement mockCompradorRepository;

    @InjectMocks
    private CompradorController compradorController;

    @Test
    void if_follow_is_success() throws NotFoundVendedorException, NotFoundCompradorException {

        //arrange
        SeguimientoDTO seguimientoDTO = new SeguimientoDTO(1,"Pedro",3,"Juan","Seguimiento exitoso");
        when(mockCompradorService.seguir(1,3)).thenReturn(seguimientoDTO);

        //act
        SeguimientoDTO resultado = mockCompradorService.seguir(1,3);

        //assert
        assertEquals("Seguimiento exitoso",resultado.getMsj());
    }

    @Test
    void if_follower_not_exist() throws NotFoundVendedorException, NotFoundCompradorException {

        //arrange
        int compradorToFind = 3;

        when(mockCompradorService.seguir(compradorToFind,3)).thenThrow(NotFoundCompradorException.class);
        //assert
        Assertions.assertThrows(NotFoundCompradorException.class, ()->mockCompradorService.seguir(compradorToFind,3));
    }
}
