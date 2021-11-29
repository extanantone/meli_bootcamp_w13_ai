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

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {


    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    //@Test
    void findCharactersThenReturnCharacters(){
        //arrange
        String name = "Skywalker";
        List<CharacterDTO> expectedList = new ArrayList<>();
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

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setName("Anakin Skywalker");
        characterDTO2.setHeight(188);
        characterDTO2.setMass(84);
        characterDTO2.setHair_color("blond");
        characterDTO2.setSkin_color("fair");
        characterDTO2.setEye_color("blue");
        characterDTO2.setBirth_year("41.9BBY");
        characterDTO2.setGender("male");
        characterDTO2.setHomeworld("Tatooine");
        characterDTO2.setSpecies("Human");

        CharacterDTO characterDTO3 = new CharacterDTO();
        characterDTO3.setName("Shmi Skywalker");
        characterDTO3.setHeight(163);
        characterDTO3.setHair_color("black");
        characterDTO3.setSkin_color("fair");
        characterDTO3.setEye_color("brown");
        characterDTO3.setBirth_year("72BBY");
        characterDTO3.setGender("female");
        characterDTO3.setHomeworld("Tatooine");
        characterDTO3.setSpecies("Human");

        expectedList.add(characterDTO1);
        expectedList.add(characterDTO2);
        expectedList.add(characterDTO3);

        //act

        List<CharacterDTO> currentList = characterRepository.findAllByNameContains(name);

        Mockito.when(characterRepository.findAllByNameContains(name))
                .thenReturn(expectedList);
        //assert
        Assertions.assertEquals(expectedList, currentList);

    }

}
