package com.starwars.controller;

import com.starwars.dto.PersonajeDto;
import com.starwars.repository.PersonajeRepository;
import com.starwars.service.IPersonajeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ControllerTest {

    @InjectMocks
    private PersonajeController controller;

    @Mock
    private IPersonajeService service;

    @Test
    public void shouldSendEmptyList(){
        Mockito.when(service.getPersonajesByName("app")).thenReturn(List.of());
        List<PersonajeDto> dtos = controller.getPersonaje("app");
        assertEquals(dtos.size(),0);
    }

    @Test
    public void shouldFindSomeItems(){
        PersonajeDto personaje = new PersonajeDto("anakin",10,10,"man","tatui","human");
        Mockito.when(service.getPersonajesByName("an")).thenReturn(List.of(personaje));
        List<PersonajeDto> dtos = controller.getPersonaje("an");
        assertEquals(dtos.size(),1);
        assertEquals(dtos.get(0),personaje);
        assertEquals(List.of(personaje),dtos);
    }

}
