package com.starwars.repository;

import com.starwars.model.Personaje;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RepositoryTest {

    private IPersonajeRepository repository = new PersonajeRepository();

    @Test
    public void shouldBeFindExistCharacter(){
        Personaje spect = new Personaje("Darth Vader",202, 136, "none", "white",
                "yellow", "41.9BBY", "male", "Tatooine", "Human");
        List<Personaje> personajes = repository.getPersonajesByName("Darth Vader");
        assertTrue(personajes.size()==1);
        assertEquals(personajes.get(0),spect);

    }

    @Test
    public  void  shouldntBeFindUnexistCharacter(){
        List<Personaje> personajes= repository.getPersonajesByName("unknow");
        assertTrue(personajes.size()==0);
    }

}
