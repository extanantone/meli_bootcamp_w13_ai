package com.example.socialmeli.integration;

import com.example.socialmeli.dto.post.PostDTO;
import com.example.socialmeli.dto.post.PromoPostDTO;
import com.example.socialmeli.dto.post.UserPostDTO;
import com.example.socialmeli.dto.post.UserPromoPostDTO;
import com.example.socialmeli.dto.product.ProductDTO;
import com.example.socialmeli.dto.user.FollowerDTO;
import com.example.socialmeli.service.repository.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.v3.core.util.Json;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest
{
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    private static ObjectMapper mapper;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException
    {
        // Not a good practice to have a static variable but I didn´t wanted to change the initial code
        // ToDo split responsability between id generation and user generation
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new Jdk8Module());
        ObjectWriter writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach
    void setTest()
    {
        userRepository.deleteAll();
    }

    @Test
    public void testPostCreationWithValidStructureAndValidUser() throws Exception {
        LocalDate date = LocalDate.of(2021, 1, 1);
        ProductDTO detail = new ProductDTO();
        detail.setBrand("mario");
        detail.setColor("blue");
        detail.setNotes("None");
        detail.setProductId(1);
        detail.setType("game");
        detail.setProductName("Nintendo");
        UserPostDTO userPostDTO = new UserPostDTO();
        userPostDTO.setUserId(1);
        userPostDTO.setIdPost(1);
        userPostDTO.setCategory(1);
        userPostDTO.setDate(date);
        userPostDTO.setDetail(detail);
        userPostDTO.setPrice(10.0);

        String body = mapper.writeValueAsString(userPostDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(body))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.price").value(10.0));
    }

    @Test
    public void testPostCreationWithValidStructureAndInvalidUser() throws Exception {
        LocalDate date = LocalDate.of(2021, 1, 1);
        ProductDTO detail = new ProductDTO();
        detail.setBrand("mario");
        detail.setColor("blue");
        detail.setNotes("None");
        detail.setProductId(1);
        detail.setType("game");
        detail.setProductName("Nintendo");
        UserPostDTO userPostDTO = new UserPostDTO();
        userPostDTO.setUserId(22);
        userPostDTO.setIdPost(1);
        userPostDTO.setCategory(1);
        userPostDTO.setDate(date);
        userPostDTO.setDetail(detail);
        userPostDTO.setPrice(10.0);

        String body = mapper.writeValueAsString(userPostDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(body))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("Acción no valida"))
                .andExpect(jsonPath("$.description").value("Error: Post no valido"));
    }

    @Test
    public void testPromoPostCreationWithValidStructureAndValidUser() throws Exception {
        LocalDate date = LocalDate.of(2021, 1, 1);
        ProductDTO detail = new ProductDTO();
        detail.setBrand("mario");
        detail.setColor("blue");
        detail.setNotes("None");
        detail.setProductId(1);
        detail.setType("game");
        detail.setProductName("Nintendo");
        UserPromoPostDTO promoPostDTO = new UserPromoPostDTO();
        promoPostDTO.setUserId(1);
        promoPostDTO.setIdPost(3);
        promoPostDTO.setCategory(1);
        promoPostDTO.setDate(date);
        promoPostDTO.setDetail(detail);
        promoPostDTO.setPrice(10.0);
        promoPostDTO.setHasPromo(true);
        promoPostDTO.setDiscount(0.1);

        String body = mapper.writeValueAsString(promoPostDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post").contentType(MediaType.APPLICATION_JSON).content(body))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.price").value(10.0))
                .andExpect(jsonPath("$.has_promo").value(true));
    }

}