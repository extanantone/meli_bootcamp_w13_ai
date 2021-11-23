package com.starwars.service;

import com.starwars.dto.PersonajeDto;
import com.starwars.model.Personaje;
import com.starwars.repository.IPersonajeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CharacterServiceTest {

    @InjectMocks
    private PersonajeService service;


    @Mock
    private IPersonajeRepository repository;


    @Test
    public void shouldFinExistCharacter(){
        Personaje personaje = new Personaje("Anakin",10,10,"hair","blue","blue","2044","man","tatuin","Human");
        Mockito.when(repository.getPersonajesByName("An")).thenReturn(List.of(personaje));
        List<PersonajeDto> dtos = service.getPersonajesByName("An");
        assertTrue(dtos.size()==1);
        assertEquals(personaje.getName(),dtos.get(0).getName());
        assertEquals(personaje.getGender(),dtos.get(0).getGender());
        assertEquals(personaje.getHeight(),dtos.get(0).getHeight());
        assertEquals(personaje.getMass(),dtos.get(0).getMass());
        assertEquals(personaje.getSpecies(),dtos.get(0).getSpecies());
        assertEquals(personaje.getHomeworld(),dtos.get(0).getHomeworld());

    }

    @Test
    public void shouldBeFindunexistCharacter(){
        Mockito.when(repository.getPersonajesByName("power")).thenReturn(List.of());
        List<PersonajeDto> dtos = service.getPersonajesByName("power");
        assertEquals(dtos.size(),0);
    }

}
