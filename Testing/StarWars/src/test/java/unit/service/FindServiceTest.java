package unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    //mock
    @Mock
    CharacterRepository repository;

    //lo que quiero testear
    @InjectMocks
    FindService service;

    @Test
    void withEmptyQueryNotFindCharacter() {
        String query = "";
        Mockito.when(repository.findAllByNameContains(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> result = service.find(query);

        Mockito.verify(repository, Mockito.atLeastOnce()).findAllByNameContains("");
        Assertions.assertThat(result.isEmpty());
    }

    @Test
    void withCorrectQueryNotFindCharacter() {
        String query = "Asdasdasd";
        Mockito.when(repository.findAllByNameContains(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> result = service.find(query);

        Mockito.verify(repository, Mockito.atLeastOnce()).findAllByNameContains("Asdasdasd");
        Assertions.assertThat(result.isEmpty());
    }

    @Test
    void withCorrectNameFindCharacter() {
        String query = "Jake";

        List<CharacterDTO> fakeList = new ArrayList<>();
        CharacterDTO jake = new CharacterDTO();
        jake.setName("Jake Long");
        fakeList.add(jake);

        Mockito.when(repository.findAllByNameContains(query)).thenReturn(fakeList);

        List<CharacterDTO> result = service.find(query);

        Mockito.verify(repository, Mockito.atLeastOnce()).findAllByNameContains("Jake");
        Assertions.assertThat(result.get(0).getName().contains("Jake"));
    }
}
