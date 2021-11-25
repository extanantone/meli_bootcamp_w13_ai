package controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    @Mock
    FindService findService;
    @InjectMocks
    FindController findController;

    @Test
    void find(){
        String query = "";
        Mockito.when(findService.find(query)).thenReturn(Collections.emptyList());
        assertEquals(Collections.emptyList(),findController.find(query));
        Mockito.verify(findService,Mockito.atLeastOnce()).find(query);
        List<CharacterDTO> lista = new ArrayList<>();
        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        lista.add(luke);
        Mockito.when(findService.find(query)).thenReturn(lista);
        assertEquals(lista,findController.find(query));
        Mockito.verify(findService,Mockito.atLeastOnce()).find(query);

    }

}