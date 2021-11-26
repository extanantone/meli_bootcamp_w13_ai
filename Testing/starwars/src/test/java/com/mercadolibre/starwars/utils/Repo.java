package com.mercadolibre.starwars.utils;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.Arrays;
import java.util.List;

public class Repo {

    public static List<CharacterDTO> SetCharacterDTO(){

        List<CharacterDTO> characterDTOList = Arrays.asList(
                new CharacterDTO( "Luke Skywalker",
                        "blond",
                        "fair",
                        "blue",
                        "19BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        172,
                        77));

        return characterDTOList;

    }


    public static List<CharacterDTO> SetCharacterDTO2(){

        List<CharacterDTO> characterDTOList = Arrays.asList(
                new CharacterDTO( "Darth Vader",
                "none",
                "white",
                "yellow",
                "41.9BBY",
                 "male",
                "Tatooine",
                "Human",
                        202,
                136),
                new CharacterDTO( "Darth Maul",
                "none",
              "red",
                "yellow",
               "54BBY",
              "male",
                "Dathomir",
               "Zabrak",
               175,
                80));

        return characterDTOList;

    }
}
