package com.lgoyenechea.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgoyenechea.socialmeli.dto.PostCreationDTO;
import com.lgoyenechea.socialmeli.dto.PostCreationPromoDTO;
import com.lgoyenechea.socialmeli.dto.ProductCreationDTO;
import com.lgoyenechea.socialmeli.dto.UserCreationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    final String CONTENT_TYPE = "application/json";
    final String REQUEST_MAPPING = "/products";

    @BeforeEach
    void setUp() throws Exception {
        UserCreationDTO dto = new UserCreationDTO("Test");
        mockMvc.perform(post("/users")
                        .contentType(CONTENT_TYPE)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }

    @Test
    void givenPostCreationDto_whenNewPost_thenOk() throws Exception {
        ProductCreationDTO productDto = new ProductCreationDTO(
                "Silla", "Silla", "Brand", "Rojo", "Notes");
        PostCreationDTO postDto = new PostCreationDTO(
                1L, "26-11-2021", productDto, 1, 100.0);

        MvcResult result = mockMvc
                .perform(post(REQUEST_MAPPING + "/post")
                        .contentType(CONTENT_TYPE)
                        .content(objectMapper.writeValueAsString(postDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id_post").exists())
                .andReturn();

        assertEquals(CONTENT_TYPE, result.getResponse().getContentType());
    }

    @Test
    void givenPostCreationPromoDto_whenNewPostWithPromo_thenOk() throws Exception {
        ProductCreationDTO productDto = new ProductCreationDTO(
                "Silla", "Silla", "Brand", "Rojo", "Notes");

        PostCreationPromoDTO postDto = new PostCreationPromoDTO();
        postDto.setUserId(1L);
        postDto.setDate("26-11-2021");
        postDto.setDetail(productDto);
        postDto.setCategory(1);
        postDto.setPrice(100.0);
        postDto.setHasPromo(true);
        postDto.setDiscount(0.3);

        MvcResult result = mockMvc
                .perform(post(REQUEST_MAPPING + "/promo-post")
                        .contentType(CONTENT_TYPE)
                        .content(objectMapper.writeValueAsString(postDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id_post").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.has_promo").value(true))
                .andReturn();

        assertEquals(CONTENT_TYPE, result.getResponse().getContentType());
    }

    /*@Test
    void givenCorrectUserId_whenCountPromoPosts_thenOk() throws Exception {
        ProductCreationDTO productDto = new ProductCreationDTO(
                "Silla", "Silla", "Brand", "Rojo", "Notes");

        PostCreationPromoDTO postDto = new PostCreationPromoDTO();
        postDto.setUserId(1L);
        postDto.setDate("26-11-2021");
        postDto.setDetail(productDto);
        postDto.setCategory(1);
        postDto.setPrice(100.0);
        postDto.setHasPromo(true);
        postDto.setDiscount(0.3);

        mockMvc.perform(post(REQUEST_MAPPING + "/promo-post")
                        .contentType(CONTENT_TYPE)
                        .content(objectMapper.writeValueAsString(postDto)))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(get(REQUEST_MAPPING + "/{userId}/promo-post/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.promo_products_count").value(1))
                .andReturn();

        assertEquals(CONTENT_TYPE, result.getResponse().getContentType());
    }*/
}
