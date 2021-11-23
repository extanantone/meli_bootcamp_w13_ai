package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CharacterRepositoryTest {

    CharacterRepositoryImpl repo  = new CharacterRepositoryImpl();

    @Test
    void ExistsCharacterInRepository(){
        //Arrange
        String query = "Darth";
        //Act
        List<CharacterDTO> list = repo.findAllByNameContains(query);
        //Assert
        System.out.println(list);
        assertEquals(2,list.size());
        assertEquals("Darth Vader", list.get(0).getName());
    }

    @Test
    void NotExistsCharacterInRepository(){
        //Arrange
        String query = "mockito";
        //Act
        List<CharacterDTO> list = repo.findAllByNameContains(query);
        //Assert
        System.out.println(list);
        assertEquals(0,list.size());

    }



}
