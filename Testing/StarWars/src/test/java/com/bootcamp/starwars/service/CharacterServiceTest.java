package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.model.Character;
import com.bootcamp.starwars.repository.ICharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTest {

    @Mock
    ICharacterRepository repository;

    @InjectMocks
    CharacterService service;

    List<Character> testCharacters = Arrays.asList(new Character(), new Character(), new Character());

    public CharacterServiceTest() {
        testCharacters.get(0).setName("Darth Maul");
        testCharacters.get(1).setName("Darth Vader");
        testCharacters.get(2).setName("Luke Skywalker");
    }

    @Test
    void withCharacterNameWith1Result() {

        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO());
        expected.get(0).setName("Luke Skywalker");

        Mockito.when(repository.getCharacters()).thenReturn(testCharacters);
        List<CharacterDTO> current = service.getCharactersByName("Luke Skywalker");

        Assertions.assertEquals(current.size(), expected.size());
        Assertions.assertEquals(current.get(0).getName(), expected.get(0).getName());
    }

    @Test
    void withCharacterNameWith2Results() {

        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO());
        expected.add(new CharacterDTO());
        expected.get(0).setName("Darth Maul");
        expected.get(1).setName("Darth Vader");

        Mockito.when(repository.getCharacters()).thenReturn(testCharacters);
        List<CharacterDTO> current = service.getCharactersByName("Darth");
        List<String> currentNames = current.stream().map(c -> c.getName()).collect(Collectors.toList());

        Assertions.assertEquals(current.size(), expected.size());
        Assertions.assertTrue(currentNames.contains(expected.get(0).getName()));
        Assertions.assertTrue(currentNames.contains(expected.get(1).getName()));
    }
}