package com.mercadolibre.starwars.unitary.Repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.utils.Repo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class CharacterRepositoryTest {

    CharacterRepositoryImpl characterRepository =  new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains(){

        String query = "Luke";

        List<CharacterDTO> current = characterRepository.findAllByNameContains(query);
        List<CharacterDTO> expet = Repo.SetCharacterDTO();

        Assertions.assertEquals(expet.get(0),current.get(0));


    }


    @Test
    void findAllByNameContains2(){

        String query = "Darth";

        List<CharacterDTO> current = characterRepository.findAllByNameContains(query);
        List<CharacterDTO> expet = Repo.SetCharacterDTO2();

        Assertions.assertEquals(expet.size(),current.size());

    }

}
