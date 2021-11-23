package Repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RepositoryTest {

    @Test
    void findAllByNameContains(){
        String query = "Luke";
        CharacterRepositoryImpl instancia = new CharacterRepositoryImpl();
        assertEquals ("Luke Skywalker",instancia.findAllByNameContains(query).get(0).getName());
        query = "Anakin";
        assertNotEquals("Luke Skywalker",instancia.findAllByNameContains(query).get(0).getName());
    }
}
