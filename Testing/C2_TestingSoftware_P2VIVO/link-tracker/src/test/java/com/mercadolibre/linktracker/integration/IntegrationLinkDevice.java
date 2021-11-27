package com.mercadolibre.linktracker.integration;

import com.mercadolibre.linktracker.dto.LinkDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationLinkDevice {
    LinkDTO correctLinkDTO;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void beforEach() {
        correctLinkDTO = new LinkDTO();
        correctLinkDTO.setLinkId(1);
    }

    // @PostMapping("create")
    //  public LinkDTO create(@RequestBody LinkDTO link)
    @Test
    public void testCreateLinkWithCorrectLink() throws Exception {
        String request = "{\"link\": \"https://www.mercadolibre.com\"}";
        this.mockMvc.perform(post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk());
    }
}
