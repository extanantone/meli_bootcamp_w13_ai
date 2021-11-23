package com.mercadolibre.starwars.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterDTOTest {

    @Test
    void createDTO(){
        CharacterDTO caracter1 = new CharacterDTO("pedro");
        CharacterDTO caracter2 = new CharacterDTO("pedro");

         assertEquals(caracter1, caracter1);
    }

}
