package com.bootcamp.socialmeliSprint1.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void TestPostProduct() throws Exception {

        String publication = "{\"user_id\":3, \"id_post\": 2, \"date\": \"10-11-2021\", \"detail\": { \"product_id\":" +
                "\"Silla Gamer\", \"type\":\"Gamer\", \"brand\": \"Racer\", \"color\": \"Black\", \"notes\": \"Special edition\"}" +
                ", \"category\": 100, \"price\":10000.00 }";

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .content(publication)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk());

    }

//    {
//        "user_id": 3,
//            "id_post": 2,
//            "date": "10-11-2021",
//            "detail": {
//        "product_id": 1,
//                "product_name": "Silla de Montar",
//                "type": "Gamer",
//                "brand": "Racer",
//                "color": "Black",
//                "notes": "Special Edition"
//    },
//        "category": 100,
//            "price": 10000000.00
//    }




}
