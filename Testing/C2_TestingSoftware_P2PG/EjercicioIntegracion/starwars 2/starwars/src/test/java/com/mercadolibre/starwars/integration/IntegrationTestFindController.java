package com.mercadolibre.starwars.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestFindController {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGiveCorrectNameForOneCharacter() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/{query}","Darth Vader"))
        .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.hair_color").value("none"));

    }

    @Test
    public void testGiveIncorrectNameForCharacter() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/{query}","ARGENTINA"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isEmpty());
    }

    public void testGiveCorrectNameForTwoCharacter() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/{query}","Darth"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$",hasSize(2)));

    }
}
