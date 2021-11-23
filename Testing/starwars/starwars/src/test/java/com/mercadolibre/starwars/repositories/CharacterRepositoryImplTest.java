package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class CharacterRepositoryImplTest {

    @InjectMocks
    CharacterRepositoryImpl repository;

    @Test
    void findAllByNameContains() {
        String name = "Cacho";

        List<CharacterDTO> characterDTO = repository.findAllByNameContains(name);

        Assertions.assertTrue(characterDTO.isEmpty());

    }

    @Test
    void findLuke(){
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


        List<CharacterDTO> charactersDTO = repository.findAllByNameContains(name);

        Assertions.assertEquals(expectedList, charactersDTO);
    }

    @Test
    void findDarth(){
        String name = "Darth";
        CharacterDTO characterDTO1 = new CharacterDTO();

        characterDTO1.setName("Darth Vader");
        characterDTO1.setHeight(202);
        characterDTO1.setMass(136);
        characterDTO1.setHair_color("none");
        characterDTO1.setSkin_color("white");
        characterDTO1.setEye_color("yellow");
        characterDTO1.setBirth_year("41.9BBY");
        characterDTO1.setGender("male");
        characterDTO1.setHomeworld("Tatooine");
        characterDTO1.setSpecies("Human");

        CharacterDTO characterDTO2= new CharacterDTO();
        characterDTO2.setName("Darth Maul");
        characterDTO2.setHeight(175);
        characterDTO2.setMass(80);
        characterDTO2.setHair_color("none");
        characterDTO2.setSkin_color("red");
        characterDTO2.setEye_color("yellow");
        characterDTO2.setBirth_year("54BBY");
        characterDTO2.setGender("male");
        characterDTO2.setHomeworld("Dathomir");
        characterDTO2.setSpecies("Zabrak");

        List<CharacterDTO> expectedList = new LinkedList<>();
        expectedList.add(characterDTO1);
        expectedList.add(characterDTO2);


        List<CharacterDTO> charactersDTO = repository.findAllByNameContains(name);

        Assertions.assertEquals(expectedList, charactersDTO);
    }

//    CharacterDTO characterDTO1 = new CharacterDTO();
//
//        characterDTO1.setName("Luke Skywalker");
//        characterDTO1.setHeight(172);
//        characterDTO1.setMass(77);
//        characterDTO1.setHair_color("blond");
//        characterDTO1.setSkin_color("fair");
//        characterDTO1.setEye_color("blue");
//        characterDTO1.setBirth_year("19BBY");
//        characterDTO1.setGender("male");
//        characterDTO1.setHomeworld("Tatooine");
//        characterDTO1.setSpecies("Human");
//
//    CharacterDTO characterDTO2 = new CharacterDTO();
//        characterDTO2.setName("Anakin Skywalker");
//        characterDTO2.setHeight(188);
//        characterDTO2.setMass(84);
//        characterDTO2.setHair_color("blond");
//        characterDTO2.setSkin_color("fair");
//        characterDTO2.setEye_color("blue");
//        characterDTO2.setBirth_year("41.9BBY");
//        characterDTO2.setGender("male");
//        characterDTO2.setHomeworld("Tatooine");
//        characterDTO2.setSpecies("Human");
//
//    CharacterDTO characterDTO3 = new CharacterDTO();
//        characterDTO3.setName("Shmi Skywalker");
//        characterDTO3.setHeight(163);
//        characterDTO3.setHair_color("black");
//        characterDTO3.setSkin_color("fair");
//        characterDTO3.setEye_color("brown");
//        characterDTO3.setBirth_year("72BBY");
//        characterDTO3.setGender("female");
//        characterDTO3.setHomeworld("Tatooine");
//        characterDTO3.setSpecies("Human");
}