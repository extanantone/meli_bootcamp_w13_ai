package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    CharacterRepository characterRepository;
    @InjectMocks
    FindService findService;
    @Test
    void find(){
        String query = "";
        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.emptyList());
        assertEquals(Collections.emptyList(),findService.find(query));
        Mockito.verify(characterRepository,Mockito.atLeastOnce()).findAllByNameContains(query);
        List<CharacterDTO> lista = new ArrayList<>();
        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        lista.add(luke);
        query = "Luke";
        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(lista);
        assertEquals(lista,findService.find(query));
        Mockito.verify(characterRepository,Mockito.atLeastOnce()).findAllByNameContains(query);
    }
}