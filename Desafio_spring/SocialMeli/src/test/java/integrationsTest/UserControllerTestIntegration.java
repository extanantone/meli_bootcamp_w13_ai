package integrationsTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.socialmeli.SocialMeliApplication;
import com.mercadolibre.socialmeli.controller.UserController;
import com.mercadolibre.socialmeli.dto.FollowDTO;
import com.mercadolibre.socialmeli.model.Follow;
import com.mercadolibre.socialmeli.model.User;
import com.mercadolibre.socialmeli.repository.SocialRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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


@SpringBootTest(classes = SocialMeliApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTestIntegration {
    @Autowired
    public MockMvc mockMvc; //Pertenece al contexto web de SpringBoot, es para realizar llamadas Http
    /**
     * Voy a necesitar un ObjectMapper para mapear un objeto a contenido json
     */
    private static ObjectMapper mapper;
    private static ObjectWriter writer;
    private User user;
    private User userToFollow;
    private Follow follow;
    private String order;
    private SocialRepositoryImpl socialRepository = new SocialRepositoryImpl();


    /**
     * Para vincular el controlador con el objecto MockMvc tengo que tener el
     * siguiente contructor.
     */
    @BeforeAll
    public static void setUp(){
        mapper = new ObjectMapper();
        writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
    }

    @BeforeEach
    public void beforeEach(){
        user = new User(1, "Maga");
        userToFollow = new User(2, "Pepe");
        order = "order_desc";
        follow = new Follow(1,2);
    }

    @Test
    public void followToUser() throws Exception {
        FollowDTO followUser = new FollowDTO(1,2);
        String endPoint = String.format("/users/%s/follow/%s", followUser.getUserId(), followUser.getIdUserToFollow());
        String bodyJson = mapper.writeValueAsString(follow);
        String responseJson = mapper.writeValueAsString(followUser);

        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.post(endPoint)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bodyJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json")).andReturn();
        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());
    }
}

