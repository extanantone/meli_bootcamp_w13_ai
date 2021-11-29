package com.bootcamp.SocialMeli.integration;

import com.bootcamp.SocialMeli.dto.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.UsuarioDTO;
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
    void testCreateANewUserThatNotExists() throws Exception{
        //Arrange
        String successJson = writer.writeValueAsString(new SuccessDTO("Usuario creado exitosamente"));

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = content().json(successJson);

        UsuarioDTO newUser = new UsuarioDTO(45, "Carlos Zambrano");
        String newUserJson = writer.writeValueAsString(newUser);

        //Act and Assert
        this.mockMvc.perform(post("/users/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newUserJson))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedJson);
    }

}
