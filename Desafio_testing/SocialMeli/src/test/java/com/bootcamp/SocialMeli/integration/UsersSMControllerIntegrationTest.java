package com.bootcamp.SocialMeli.integration;

import com.bootcamp.SocialMeli.dto.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.response.ErrorDTO;
import com.bootcamp.SocialMeli.dto.response.SuccessDTO;
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
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersSMControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JSR310Module())
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    void testGivenExistingUserAndSellerTheUserFollowsSellerSuccessfully() throws Exception {
        //Arrange
        String successJson = writer.writeValueAsString(new SuccessDTO("Followed successfully"));

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(successJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        //Act and Assert
        this.mockMvc.perform(post("/users/{user_id}/follow/{user_id_to_follow}", 1, 3))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedJson);
    }

    @Test
    void testGivenExistingSellerAndUserThatNotFollowUnfollowsHimThenError() throws Exception {
        //Arrange
        ErrorDTO error = new ErrorDTO();
        error.setTipo("NotFollowException");
        error.setMensaje("El usuario (ID 2) no es seguidor del vendedor (ID 4)");

        String successJson = writer.writeValueAsString(error);

        ResultMatcher expectedStatus = status().isBadRequest();
        ResultMatcher expectedJson = content().json(successJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        //Act and Assert
        this.mockMvc.perform(post("/users/{user_id}/unfollow/{user_id_to_follow}", 2, 4))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedJson);
    }

    @Test
    void testCreateAValidPostForAnExistingUser() throws Exception {
        //Arrange
        String successJson = writer.writeValueAsString(new SuccessDTO("Publicacion creada correctamente."));

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(successJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        PublicacionDTO publicacionDTO = new PublicacionDTO();
        publicacionDTO.setUserId(1);
        publicacionDTO.setIdPost(15);
        publicacionDTO.setDate(LocalDate.of(2021,11,10));
        publicacionDTO.setCategory(102);
        publicacionDTO.setPrice(550.0);
        publicacionDTO.setDetail(new DetalleProductoDTO(6, "Teclado inalámbrico para PC", "normal","Genius","Black","Último en stock"));

        String payloadJson = writer.writeValueAsString(publicacionDTO);

        //Act and Assert
        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedJson);
    }

    @Test
    void testCreateAValidPromoForAnExistingUser() throws Exception {

    }

    @Test
    void testGetCantPromocionesFromASellerWithPromociones(){

    }
}
