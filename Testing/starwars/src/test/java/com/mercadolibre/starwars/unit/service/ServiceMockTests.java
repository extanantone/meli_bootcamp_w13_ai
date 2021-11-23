package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ServiceMockTests {
    //mock
    @Mock
    CharacterRepositoryImpl repo;

    //lo que quiero testear
    @InjectMocks
    FindService service;

    @Test
    void testConMock(){
        // Arrange
        String query = "Luke";
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Luke Skywalker","blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human",172,77));
        // Mocks
        Mockito.when(repo.findAllByNameContains(query)).thenReturn(expected);

        List<CharacterDTO> current = service.find(query);

       Mockito.verify(repo, Mockito.atLeastOnce()).findAllByNameContains(Mockito.anyString());
        Assertions.assertEquals(current, expected);
    }

}
