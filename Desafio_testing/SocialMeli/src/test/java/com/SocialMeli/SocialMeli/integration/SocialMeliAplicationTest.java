package com.SocialMeli.SocialMeli.integration;

import com.SocialMeli.SocialMeli.dto.PostDTORequest;
import com.SocialMeli.SocialMeli.dto.PostPromoDTORequest;
import com.SocialMeli.SocialMeli.dto.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
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

@SpringBootTest
@AutoConfigureMockMvc
public class SocialMeliAplicationTest {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .findAndRegisterModules()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();
    }

    @Test
    void userFollowersCountSuccess() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void followSellerSuccess() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{user_id_to_follow}", 1, 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getFollowersSuccess() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followers/list", 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getFollowedSuccess() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followed/list", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void unFollowSellerSuccess() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{user_id_to_unfollow}", 1, 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createPostSuccess() throws Exception{
        PostDTORequest postDTORequest = new PostDTORequest();
        postDTORequest.setId_post(1);
        postDTORequest.setUser_id(3);
        postDTORequest.setPrice(1000.0);
        postDTORequest.setCategory(1);
        postDTORequest.setDate(LocalDate.now());
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(1);
        productDTO.setProduct_name("Producto");
        productDTO.setColor("Blanco");
        productDTO.setType("Tipo");
        productDTO.setBrand("Marca");
        productDTO.setNotes("Test");
        postDTORequest.setDetail(productDTO);

        String payloadJSON = writer.writeValueAsString(postDTORequest);

        this.mockMvc.perform(
                    MockMvcRequestBuilders.post("/products/post")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(payloadJSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createPostThenValidarionFail() throws Exception{
        PostDTORequest postDTORequest = new PostDTORequest();
        //postDTORequest.setId_post(1);
        postDTORequest.setUser_id(3);
        postDTORequest.setPrice(1000.0);
        postDTORequest.setCategory(1);
        postDTORequest.setDate(LocalDate.now());
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(1);
        productDTO.setProduct_name("Producto");
        productDTO.setColor("Blanco");
        productDTO.setType("Tipo");
        productDTO.setBrand("Marca");
        productDTO.setNotes("Test");
        postDTORequest.setDetail(productDTO);

        String payloadJSON = writer.writeValueAsString(postDTORequest);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getByUserIdSuccess() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{user_id}/list", 1)
                        .param("order", "date_asc")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getByUserIdThenOrderFormatIncorrect() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{user_id}/list", 1)
                        .param("order", "date_")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void createPromoSuccess() throws Exception{
        PostPromoDTORequest postPromoDTORequest = new PostPromoDTORequest();
        postPromoDTORequest.setId_post(90);
        postPromoDTORequest.setUser_id(3);
        postPromoDTORequest.setPrice(1000.0);
        postPromoDTORequest.setCategory(1);
        postPromoDTORequest.setDate(LocalDate.now());
        postPromoDTORequest.setHas_promo(true);
        postPromoDTORequest.setDiscount(5.0);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(1);
        productDTO.setProduct_name("Producto");
        productDTO.setColor("Blanco");
        productDTO.setType("Tipo");
        productDTO.setBrand("Marca");
        productDTO.setNotes("Test");
        postPromoDTORequest.setDetail(productDTO);

        String payloadJSON = writer.writeValueAsString(postPromoDTORequest);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/promo-post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createPromoThenValidationFail() throws Exception{
        PostPromoDTORequest postPromoDTORequest = new PostPromoDTORequest();
        //postPromoDTORequest.setId_post(1);
        postPromoDTORequest.setUser_id(3);
        postPromoDTORequest.setPrice(1000.0);
        postPromoDTORequest.setCategory(1);
        postPromoDTORequest.setDate(LocalDate.now());
        postPromoDTORequest.setHas_promo(true);
        postPromoDTORequest.setDiscount(5.0);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(1);
        productDTO.setProduct_name("Producto");
        productDTO.setColor("Blanco");
        productDTO.setType("Tipo");
        productDTO.setBrand("Marca");
        productDTO.setNotes("Test");
        postPromoDTORequest.setDetail(productDTO);

        String payloadJSON = writer.writeValueAsString(postPromoDTORequest);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/promo-post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getSellerPromosCountSuccess() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/{userId}/promo-post/count", 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getSellerPromosCountThenSellerNotFound() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/{userId}/promo-post/count", 99))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void getSellerPromosSuccess() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/{user_id}/list", 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getSellerPromosThenUserNotFound() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/{userId}/list", 99))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
