package integrationsTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.socialmeli.controller.UserController;
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


@SpringBootTest(classes = UserController.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
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
        user = new User();
        userToFollow = new User();
        user.setId(1);
        user.setName("Maga");
        userToFollow.setId(2);
        userToFollow.setName("Pepe");
        // user = new User(1,"Pepe");
        // userToFollow = new User(2,"Maggy");
        order = "order_desc";
        follow = new Follow(1,2);
        if(socialRepository.findUserById(user.getId())==null)
            socialRepository.save(user);
        if(socialRepository.findUserById(userToFollow.getId())==null)
            socialRepository.save(userToFollow);
    }
    @Test
    public void followToUser() throws Exception {
        String endPoint = "/users/{user_id}/follow/{user_id_to_follow}";
        Follow followUser = new Follow(1,2);
        String bodyJson = mapper.writeValueAsString(follow);
        String responseJson = mapper.writeValueAsString(followUser);

        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bodyJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType("application/json")).andReturn();
        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());
    }
}

