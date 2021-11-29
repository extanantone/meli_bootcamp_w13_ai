package com.socialMeli.SocialMeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.ProductDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;



import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class SocialMeliIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void followCorrectUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{follower}/follow/{followed}",2,1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.following.[0]").value(1));

    }

    @Test
    void followIncorrectUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{follower}/follow/{followed}",2,5))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Usuario no encontrado"));
    }

    @Test
    void followUserSelf() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{follower}/follow/{followed}",2,2))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No se puede seguir a si mismo"));
    }

    @Test
    void followFollowedUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{follower}/follow/{followed}",1,2));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{follower}/follow/{followed}",1,2))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Ya se sigue al usuario"));
    }

    @Test
    void countFollowersUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{follower}/follow/{followed}",1,2));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user}/followers/count",2))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followers_count").value(1));
    }

    @Test
    void getFollowersList() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{follower}/follow/{followed}",1,2));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{follower}/follow/{followed}",3,2));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user}/followers/list",2))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followers.[0].user_name").value("usuario1"))
                .andExpect(jsonPath("$.followers.[1].user_name").value("vendedor1"));
    }

    @Test
    void getFollowedList() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{follower}/follow/{followed}",1,2));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{follower}/follow/{followed}",1,3));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user}/followed/list",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followed.[0].user_name").value("usuario2"))
                .andExpect(jsonPath("$.followed.[1].user_name").value("vendedor1"));
    }

    @Test
    void postProduct() throws Exception {
        //Post
        LocalDate date1 = LocalDate.of(2021,11,25);
        ProductDetails productDetails = new ProductDetails(1,"producto1","Prueba","marca","verde","ninguna");
        Post post1 = new Post(2,1,date1,productDetails,1,10.0);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).registerModule(new JSR310Module()).writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(post1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id_post").value(1))
                .andExpect(jsonPath("$.user_id").value(2));
    }

    @Test
    void postProductDuplicateID() throws Exception {
        //Post
        LocalDate date1 = LocalDate.of(2021,11,25);
        ProductDetails productDetails = new ProductDetails(1,"producto1","Prueba","marca","verde","ninguna");
        Post post1 = new Post(2,2,date1,productDetails,1,10.0);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).registerModule(new JSR310Module()).writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(post1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payloadJson));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Ya existe un post con ese id"));
    }
/*
    @Test
    void getProductsFollowedList() throws Exception {
        //Post
        LocalDate date1 = LocalDate.of(2021,11,25);
        ProductDetails productDetails = new ProductDetails(1,"producto1","Prueba","marca","verde","ninguna");
        Post post1 = new Post(3,4,date1,productDetails,1,10.0);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).registerModule(new JSR310Module()).writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(post1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payloadJson));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{follower}/follow/{followed}",4,3));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{user_id}/list",4))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.posts.[0].id_post").value(4));
    }*/

}
