package com.example.socialmeli.demo.integration.IntegrationTestPost;


import com.example.socialmeli.demo.dto.controllerToService.DTOPost;
import com.example.socialmeli.demo.dto.controllerToService.DTOProduct;
import com.example.socialmeli.demo.exception.UserNotFoundException;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestPostController {

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

    //US 0005
    @Test
    public void testCreatePostWithValidParamsAndSaveIt() throws Exception {

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

        DTOPost post = new DTOPost(3,33,parsedDate,detail,5,1025.4);
        String payloadJsonPost = writer.writeValueAsString(post);

       this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
               .contentType(MediaType.APPLICATION_JSON)
               .content(payloadJsonPost))
               .andDo(MockMvcResultHandlers.print())
               .andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    public void testReturnPostsFromDeterminatedUserNewerThanTwoWeeksOld() throws Exception {

//Hacemos que el usuario siga al vendedor a testear
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",1,3))
                .andDo(MockMvcResultHandlers.print());


        //Cargaremos la publicacion para el vendedor

        DTOProduct detail= new DTOProduct();
        detail.setProductId(1);
        detail.setProductName("Playstation 4");
        detail.setColor("black");
        detail.setBrand("Sony");
        detail.setType("CH43432");
        detail.setNotes("Buen estado");


        //Posts validos
        int expectedValidPosts = 3;

        //Valido
        DTOPost post1 = new DTOPost(3,1,LocalDate.of(2021,11,28),detail,5,10040.40);
        //No valido
        DTOPost post2 = new DTOPost(3,2,LocalDate.of(2021,10,26),detail,5,10040.40);
        //Valido
        DTOPost post3 = new DTOPost(3,3,LocalDate.of(2021,11,26),detail,5,10040.40);
        //Valido
        DTOPost post4 = new DTOPost(3,4,LocalDate.of(2021,11,30),detail,5,10040.40);
        //No Valido
        DTOPost post5 = new DTOPost(3,5,LocalDate.of(2021,9,15),detail,5,10040.40);

        String payloadJsonPost1 = writer.writeValueAsString(post1);
        String payloadJsonPost2 = writer.writeValueAsString(post2);
        String payloadJsonPost3 = writer.writeValueAsString(post3);
        String payloadJsonPost4 = writer.writeValueAsString(post4);
        String payloadJsonPost5 = writer.writeValueAsString(post5);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPost1));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPost2));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPost3));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPost4));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJsonPost5));

        //Perform action to search newest posts:

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts.length()").value(expectedValidPosts));



    }


}
