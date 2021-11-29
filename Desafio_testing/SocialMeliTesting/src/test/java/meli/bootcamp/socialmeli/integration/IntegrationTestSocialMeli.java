package meli.bootcamp.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import meli.bootcamp.socialmeli.dto.FollowedListDTO;
import meli.bootcamp.socialmeli.dto.NewUserDTO;
import meli.bootcamp.socialmeli.dto.UserDTO;
import meli.bootcamp.socialmeli.mapper.UserMapper;
import meli.bootcamp.socialmeli.model.User;
import meli.bootcamp.socialmeli.model.UserFollow;
import meli.bootcamp.socialmeli.repository.UserFollowRepository;
import meli.bootcamp.socialmeli.repository.UserRepository;
import meli.bootcamp.socialmeli.utils.TestUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.regex.Matcher;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestSocialMeli {
    @Autowired
    MockMvc mockMvc;

    static UserRepository userRepository= new UserRepository();
    static UserFollowRepository userFollowRepository= new UserFollowRepository();

    private static ObjectWriter objectWriter;
    private static ObjectMapper objectMapper;

    User user1;
    User user2;
    FollowedListDTO followedListDTO;

    @BeforeAll
    public static void setUp(){
        objectMapper= new ObjectMapper();
        objectWriter= objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();
    }

    @BeforeEach
    public void beforeEach(){
        user1= userRepository.findUserById(1);
        user2= userRepository.findUserById(2);

    }

    @Test
    public void testFollowUserAndAnalyzeResponse() throws Exception {
        LinkedHashMap<String, String> map= new LinkedHashMap<>();
        map.put("code", "200");
        map.put("response", "Usuario " + user1.getUserId() + " siguiendo a " + user2.getUserId());
        System.out.println(Map.of());
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{user_id}/follow/{user_id_to_follow}", user1.getUserId(), user2.getUserId()))
                //MockMvcRequestBuilders.get("/users/{user_id}/followed/list", user1.getUserId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.response", Matchers.contains(map)));
    }

}
