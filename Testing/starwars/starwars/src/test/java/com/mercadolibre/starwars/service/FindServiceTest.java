package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepositoryImpl repository;

    @InjectMocks
    FindService service;

    @Test
    void find() {
        String name = "Luke";
        CharacterDTO characterDTO1 = new CharacterDTO();

        characterDTO1.setName("Luke Skywalker");
        characterDTO1.setHeight(172);
        characterDTO1.setMass(77);
        characterDTO1.setHair_color("blond");
        characterDTO1.setSkin_color("fair");
        characterDTO1.setEye_color("blue");
        characterDTO1.setBirth_year("19BBY");
        characterDTO1.setGender("male");
        characterDTO1.setHomeworld("Tatooine");
        characterDTO1.setSpecies("Human");

        List<CharacterDTO> expectedList = new LinkedList<>();
        expectedList.add(characterDTO1);

        Mockito.when(repository.findAllByNameContains(name)).thenReturn(expectedList);

        List<CharacterDTO> current = service.find(name);

        Mockito.verify(repository, Mockito.atLeastOnce()).findAllByNameContains(Mockito.anyString());
        Assertions.assertEquals(expectedList, current);

    }
}