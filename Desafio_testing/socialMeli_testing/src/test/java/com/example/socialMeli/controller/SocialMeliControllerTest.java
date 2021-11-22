package com.example.socialMeli.controller;

import com.example.socialMeli.dto.RespuestaSimpleDTO;
import com.example.socialMeli.exceptions.UsuarioNoEncontradoError;
import com.example.socialMeli.service.ISocialMeliService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class SocialMeliControllerTest {
    @Mock
    private ISocialMeliService service ;
    @InjectMocks
    private SocialMeliController controller;

    @Test
    void sigueAUnVendedor() throws UsuarioNoEncontradoError {
        //controller.prueba();
        service.cargarDatos();
        int comprador =1, vendedor = 3;
        RespuestaSimpleDTO rta = new RespuestaSimpleDTO("El comprador "+comprador+" ha seguido con exito al vendedor "+vendedor, 200);
        when(service.seguir(comprador, vendedor)).thenReturn(rta);

        ResponseEntity<RespuestaSimpleDTO> rta2 = controller.seguir(comprador, vendedor);
        //assert
        
    }
}
