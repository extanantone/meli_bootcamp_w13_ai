package SocialMeli.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {
    @Autowired
    private MockMvc mockMvc;

    //DATA
    String requestSeller = "{\"user_id\": 50,\"user_name\": \"testSeller\",\"seller\": true}";
    String requestSeller2 = "{\"user_id\": 60,\"user_name\": \"testSellerb\",\"seller\": true}";
    String requestCustomer = "{\"user_id\": 51,\"user_name\": \"testCustomera\",\"seller\": false}";
    String requestCustomer2 = "{\"user_id\": 52,\"user_name\": \"testCustomerb\",\"seller\": false}";


    @BeforeEach
    void setUp() throws Exception {
        this.mockMvc.perform(
                post("/user/newUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestSeller));
        this.mockMvc.perform(
                post("/user/newUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestCustomer));
        this.mockMvc.perform(
                post("/user/newUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestCustomer2));
        this.mockMvc.perform(
                post("/user/newUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestSeller2));
        this.mockMvc.perform(
                post("/users/51/follow/50")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(
                post("/users/52/follow/50")).andDo(print()).andExpect(status().isOk());
    }

    @AfterEach
    void unfollows() throws Exception{
        this.mockMvc.perform(
                post("/users/51/unfollow/50")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(
                post("/users/52/unfollow/50")).andDo(print()).andExpect(status().isOk());
    }

    //US 0001
    @Test
    void followUser() throws Exception {
        this.mockMvc.perform(
                post("/users/52/follow/60")).andDo(print()).andExpect(status().isOk());
    }

    //US0007
    @Test
    void unfollowUser() throws Exception {
        this.mockMvc.perform(
                post("/users/51/follow/60")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(
                post("/users/51/unfollow/60")).andDo(print()).andExpect(status().isOk());
    }

    //US0002
    @Test
    void followerCount() throws Exception {
        this.mockMvc.perform(
                        get("/users/50/followers/count"))
                .andExpect(status().isOk())
                .andDo(print()).andExpect(jsonPath("$.followers_count").value("2"));
    }

    //US0003
    @Test
    void followerList() throws Exception {
        this.mockMvc.perform(
                        get("/users/50/followers/list"))
                .andExpect(status().isOk())
                .andDo(print()).andExpect(jsonPath("$.followers.[0].user_id").value("51"))
                .andDo(print()).andExpect(jsonPath("$.followers.[1].user_id").value("52"));
    }

    //US0004
    @Test
    void followedList() throws Exception {
        this.mockMvc.perform(
                        get("/users/51/followed/list"))
                .andExpect(status().isOk())
                .andDo(print()).andExpect(jsonPath("$.followed.[0].user_id").value("50"));
    }


    //US0008
    @Test
    void orderFollows() throws Exception {
        this.mockMvc.perform(
                        get("/users/50/followers/list?order=name_desc"))
                .andExpect(status().isOk())
                .andDo(print()).andExpect(jsonPath("$.followers.[0].user_id").value("52"))
                .andDo(print()).andExpect(jsonPath("$.followers.[1].user_id").value("51"));
        this.mockMvc.perform(
                        get("/users/50/followers/list?order=name_asc"))
                .andExpect(status().isOk())
                .andDo(print()).andExpect(jsonPath("$.followers.[0].user_id").value("51"))
                .andDo(print()).andExpect(jsonPath("$.followers.[1].user_id").value("52"));
    }

}
