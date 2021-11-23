package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryTest {

    CharacterRepository characterRepository = new CharacterRepositoryImpl();

    @Test
    void shouldRetrieveAllCharactersWithAInName() {
        List<CharacterDTO> characterDTOList = characterRepository.findAllByNameContains("A");

        assertEquals(2, characterDTOList.size());
    }

    @Test
    void shouldNotFindCharacters() {
        List<CharacterDTO> characterDTOList = characterRepository.findAllByNameContains("$");

        assertEquals(0, characterDTOList.size());
    }

    @Test
    void shouldFindAllCharactersWithSpaceInName() {
        List<CharacterDTO> characterDTOList = characterRepository.findAllByNameContains("");

        assertEquals(4, characterDTOList.size());
    }

    @Test
    void shouldFindAllCharactersWithDashInName() {
        List<CharacterDTO> characterDTOList = characterRepository.findAllByNameContains("-");

        assertEquals(2, characterDTOList.size());
    }

    @Test
    void shouldFindAllCharacters() {
        List<CharacterDTO> characterDTOList = characterRepository.findAllByNameContains(" ");

        assertEquals(2, characterDTOList.size());
    }

    @Test
    void shouldFindDarthVader() {
        List<CharacterDTO> characterDTOList = characterRepository.findAllByNameContains("Darth");

        assertEquals(1, characterDTOList.size());
    }

    @Test
    void shouldThrowNullPointerExcepction() { assertThrows(NullPointerException.class, () -> characterRepository.findAllByNameContains(null)); }
}
