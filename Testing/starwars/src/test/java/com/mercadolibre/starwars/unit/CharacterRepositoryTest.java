package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CharacterRepositoryTest {
    private CharacterRepositoryImpl characterRepo = new CharacterRepositoryImpl();

    @Test
    public void nameToSearchFindsAllCharactersThatContainIt() {

        String nameToSearch = "Darth";

        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        List<CharacterDTO> expectedDarthCast = Arrays.asList(darthVader, darthMaul);

        List<CharacterDTO> resultDarthCast = this.characterRepo.findAllByNameContains(nameToSearch);

        Assertions.assertEquals(expectedDarthCast.get(0).getName(), resultDarthCast.get(0).getName());
        Assertions.assertEquals(expectedDarthCast.get(1).getName(), resultDarthCast.get(1).getName());
        Assertions.assertEquals(2, resultDarthCast.size());

    }

    @Test
    public void nameToSearchIsNotFoundInRepository() {

        String nameToSearch = "Banana";
        List<CharacterDTO> resultDarthCast = this.characterRepo.findAllByNameContains(nameToSearch);

        Assertions.assertTrue(resultDarthCast.isEmpty());
    }
}