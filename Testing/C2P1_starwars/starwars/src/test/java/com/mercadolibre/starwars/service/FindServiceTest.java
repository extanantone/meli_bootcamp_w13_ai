package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;

public class FindServiceTest {

    CharacterRepositoryImpl repository = new CharacterRepositoryImpl();
    FindService service = new FindService(repository);

    @Test
    void findServiceTest(){
        // Arrange


        // Act


        // Assert


    }
}
