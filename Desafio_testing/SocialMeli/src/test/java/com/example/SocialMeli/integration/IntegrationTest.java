package com.example.SocialMeli.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    /*@Test
    public void testGiveUserIdReturnPublicationsOnlyWithPromo() throws Exception {

        MvcResult responde = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/{user_id}/list",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        Assertions.assertEquals();
/*
* String jsonList = writer.writeValueAsString(expectedList);
        MvcResult response =
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/{query}","Skywalker"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.height").value(202))
                .andReturn();

        Assertions.assertEquals(jsonList,response.getResponse().getContentAsString());
*
    }*/

    @Test
    public void testGivePublicationReturnOk() throws Exception {
        String publication = "{\"user_id\":3,\"id_post\":1,\"date\":\"04-12-2021\",\"detail\":{\"product_id\":1," +
                "\"product_name\":\"Silla Gamer\",\"type\":\"Gamer\",\"brand\":\"Racer\",\"color\":\"Red\"," +
                "\"notes\":\"Special Edition\"},\"category\":1,\"price\":10.0,\"has_promo\":false,\"discount\":0.0}";

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                .content(publication)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGivePublicationWithPromoReturnOk() throws Exception {
        String publication = "{\"user_id\":3,\"id_post\":2,\"date\":\"04-12-2021\",\"detail\":{\"product_id\":1," +
                "\"product_name\":\"Silla Gamer\",\"type\":\"Gamer\",\"brand\":\"Racer\",\"color\":\"Red\"," +
                "\"notes\":\"Special Edition\"},\"category\":1,\"price\":10.0,\"has_promo\":true,\"discount\":0.25}";

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/promo-post")
                        .content(publication)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
