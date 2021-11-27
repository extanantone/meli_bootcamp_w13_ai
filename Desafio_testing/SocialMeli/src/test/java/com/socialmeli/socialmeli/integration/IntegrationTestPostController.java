package com.socialmeli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.socialmeli.socialmeli.dto.post.PostDTO;
import com.socialmeli.socialmeli.dto.post.ProductDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestPostController {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;



    @Test
    public void newPostWithCorrectPostDto() throws Exception {
        /*ProductDTO p = new ProductDTO(1,"name","type","large","blue","notes");
        PostDTO post = new PostDTO(1,1, LocalDate.now(),p,1,10.00,false,0.0);
        String json = writer.writeValueAsString(post);*/
        String json = "{\"user_id\":1,\"id_post\":5,\"date\":\"27-11-2011\",\"detail\":{\"product_id\":1," +
                "\"product_name\":\"name\",\"type\":\"type\",\"brand\":\"large\",\"color\":\"blue\"," +
                "\"notes\":\"notes\"},\"category\":1,\"price\":10.0,\"has_promo\":false,\"discount\":0.0}";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/products/post")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value("true"))
        ;


    }
}
