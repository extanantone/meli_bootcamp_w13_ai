package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestCharacters {
        static List<CharacterDTO> expectedList = new ArrayList<>();
        private static ObjectWriter writer;
    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    static void data(){

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Luke Skywalker");
        characterDTO1.setHeight(172);
        characterDTO1.setMass(77);
        characterDTO1.setHair_color("blond");
        characterDTO1.setSkin_color("fair");
        characterDTO1.setEye_color("blue");
        characterDTO1.setBirth_year("19BBY");
        characterDTO1.setGender("male");
        characterDTO1.setHomeworld("Tatooine");
        characterDTO1.setSpecies("Human");

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setName("Anakin Skywalker");
        characterDTO2.setHeight(188);
        characterDTO2.setMass(84);
        characterDTO2.setHair_color("blond");
        characterDTO2.setSkin_color("fair");
        characterDTO2.setEye_color("blue");
        characterDTO2.setBirth_year("41.9BBY");
        characterDTO2.setGender("male");
        characterDTO2.setHomeworld("Tatooine");
        characterDTO2.setSpecies("Human");

        CharacterDTO characterDTO3 = new CharacterDTO();
        characterDTO3.setName("Shmi Skywalker");
        characterDTO3.setHeight(163);
        characterDTO3.setHair_color("black");
        characterDTO3.setSkin_color("fair");
        characterDTO3.setEye_color("brown");
        characterDTO3.setBirth_year("72BBY");
        characterDTO3.setGender("female");
        characterDTO3.setHomeworld("Tatooine");
        characterDTO3.setSpecies("Human");

        expectedList.add(characterDTO1);
        expectedList.add(characterDTO2);
        expectedList.add(characterDTO3);
    }

    @Test
    public void testGivenNameGetTwoCharacters() throws Exception {

        String jsonList = writer.writeValueAsString(expectedList);
        MvcResult response =
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/{query}","Skywalker"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.height").value(202))
                .andReturn();

        Assertions.assertEquals(jsonList,response.getResponse().getContentAsString());
    }
}
