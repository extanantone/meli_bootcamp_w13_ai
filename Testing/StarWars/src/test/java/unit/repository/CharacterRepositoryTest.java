package unit.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CharacterRepositoryTest {

    @Test
    void withValidNameFindsCharacters(){

        CharacterRepository repository = new CharacterRepositoryImpl();

        String query = "Luke";

        String currentName = repository.findAllByNameContains(query).get(0).getName();

        Assertions.assertEquals(currentName, "Luke Skywalker");

    }
}
