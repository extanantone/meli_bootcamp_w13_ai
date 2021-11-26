package com.example.socialmeli.demo.integration.IntegrationTestPromoPost;

import com.example.socialmeli.demo.dto.controllerToService.DTOPost;
import com.example.socialmeli.demo.dto.controllerToService.DTOProduct;
import com.example.socialmeli.demo.dto.controllerToService.DTOPromoPost;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
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
import java.time.format.DateTimeFormatter;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestPromoPostController {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;


    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .registerModule(new JSR310Module())
                .writer();

    }


    @Test
    public void testCreatePromoPostWithValidParamsAndSaveIt() throws Exception {

        DTOProduct detail= new DTOProduct();
        detail.setProductId(33);
        detail.setProductName("Silla Gamer");
        detail.setColor("RedBlack");
        detail.setBrand("Racer");
        detail.setType("Gamer");
        detail.setNotes("Special edition");

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = LocalDate.now().format(formatters);
        LocalDate parsedDate = LocalDate.parse(text, formatters);

        DTOPromoPost post = new DTOPromoPost(3,33,parsedDate,detail,5,1025.4,true,0.5);
        String payloadJsonPromoPost = writer.writeValueAsString(post);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPromoPost))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    public void testToBringPromoPostsCountFromUserWithAtLeastOneProduct() throws Exception {

        DTOProduct detail= new DTOProduct();
        detail.setProductId(33);
        detail.setProductName("Silla Gamer");
        detail.setColor("RedBlack");
        detail.setBrand("Racer");
        detail.setType("Gamer");
        detail.setNotes("Special edition");

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = LocalDate.now().format(formatters);
        LocalDate parsedDate = LocalDate.parse(text, formatters);


        int expectedPromoPosts = 2;

        //Validos
        DTOPromoPost promoPost1 = new DTOPromoPost(3,33,parsedDate,detail,5,1025.4,true,0.5);
        DTOPromoPost promoPost2 = new DTOPromoPost(3,34,parsedDate,detail,5,1025.4,true,0.7);

        //No validos
        DTOPromoPost promoPost3 = new DTOPromoPost(3,35,parsedDate,detail,5,1025.4,false,0.7);

        String payloadJsonPromoPost1 = writer.writeValueAsString(promoPost1);
        String payloadJsonPromoPost2 = writer.writeValueAsString(promoPost2);
        String payloadJsonPromoPost3 = writer.writeValueAsString(promoPost3);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPromoPost1));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPromoPost2));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPromoPost3));


        //Final validation:

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/{userId}/promo-post/count",3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.promo_products_count").value(expectedPromoPosts));



    }

    @Test
    public void testToBringPromoPostsListFromUserWithAtLeastOneProduct() throws Exception {

        DTOProduct detail= new DTOProduct();
        detail.setProductId(33);
        detail.setProductName("Silla Gamer");
        detail.setColor("RedBlack");
        detail.setBrand("Racer");
        detail.setType("Gamer");
        detail.setNotes("Special edition");

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = LocalDate.now().format(formatters);
        LocalDate parsedDate = LocalDate.parse(text, formatters);


        int expectedPromoPosts = 2;

        //Validos
        DTOPromoPost promoPost1 = new DTOPromoPost(4,33,parsedDate,detail,5,1025.4,true,0.5);
        DTOPromoPost promoPost2 = new DTOPromoPost(4,34,parsedDate,detail,5,1025.4,true,0.7);

        //No validos
        DTOPromoPost promoPost3 = new DTOPromoPost(4,35,parsedDate,detail,5,1025.4,false,0.7);

        String payloadJsonPromoPost1 = writer.writeValueAsString(promoPost1);
        String payloadJsonPromoPost2 = writer.writeValueAsString(promoPost2);
        String payloadJsonPromoPost3 = writer.writeValueAsString(promoPost3);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPromoPost1));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPromoPost2));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPromoPost3));


        //Final validation:

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/{user_id}/list",4))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts.length()").value(expectedPromoPosts));



    }

}
