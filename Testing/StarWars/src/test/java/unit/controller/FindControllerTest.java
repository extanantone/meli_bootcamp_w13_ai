package unit.controller;

import com.mercadolibre.starwars.controller.FindController;
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
public class FindControllerTest {
    //mock
    @Mock
    FindService service;

    //lo que quiero testear
    @InjectMocks
    FindController controller;

    @Test
    void withEmptyQueryNotFindCharacter() {
        String query = "";
        Mockito.when(service.find(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> result = controller.find(query);

        Mockito.verify(service, Mockito.atLeastOnce()).find("");
        Assertions.assertThat(result.isEmpty());
    }

    @Test
    void withCorrectQueryNotFindCharacter() {
        String query = "Asdasdasd";
        Mockito.when(service.find(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> result = controller.find(query);

        Mockito.verify(service, Mockito.atLeastOnce()).find("Asdasdasd");
        Assertions.assertThat(result.isEmpty());
    }

    @Test
    void withCorrectNameFindCharacter() {
        String query = "Jake";

        List<CharacterDTO> fakeList = new ArrayList<>();
        CharacterDTO jake = new CharacterDTO();
        jake.setName("Jake Long");
        fakeList.add(jake);

        Mockito.when(service.find(query)).thenReturn(fakeList);

        List<CharacterDTO> result = controller.find(query);

        Mockito.verify(service, Mockito.atLeastOnce()).find("Jake");
        Assertions.assertThat(result.get(0).getName().contains("Jake"));
    }
}
