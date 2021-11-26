package SocialMeli.integration;

import org.junit.jupiter.api.*;
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
public class PostsTest {

    @Autowired
    private MockMvc mockMvc;

    String requestSeller = "{\"user_id\": 50,\"user_name\": \"testSeller\",\"seller\": true}";
    String requestSeller2 = "{\"user_id\": 60,\"user_name\": \"testSellerb\",\"seller\": true}";
    String requestCustomer = "{\"user_id\": 51,\"user_name\": \"testCustomera\",\"seller\": false}";

    String post1 = "{" +
            "\"user_id\": 50, \"id_post\": 18," +
            "\"date\": \"26-11-2021\", \"detail\": {" +
            "\"product_id\": 1, \"product_name\": \"Silla Gamer\", \"type\": \"Gamer\"," +
            "\"brand\": \"Racer\"," +
            "\"color\": \"RedBlack\"," +
            "\"notes\": \"Special Edition\"" +
            "},\n" +
            "\"category\": 100, \"price\": 1500.50" +
            "}";

    String post2 = "{" +
            "\"user_id\": 50, \"id_post\": 19," +
            "\"date\": \"25-11-2021\", \"detail\": {" +
            "\"product_id\": 1, \"product_name\": \"Silla Gamer\", \"type\": \"Gamer\"," +
            "\"brand\": \"Racer\"," +
            "\"color\": \"RedBlack\"," +
            "\"notes\": \"Special Edition\"" +
            "},\n" +
            "\"category\": 100, \"price\": 1500.50" +
            "}";

    String post3 = "{" +
            "\"user_id\": 60, \"id_post\": 20," +
            "\"date\": \"25-11-2021\", \"detail\": {" +
            "\"product_id\": 1, \"product_name\": \"Silla Gamer\", \"type\": \"Gamer\"," +
            "\"brand\": \"Racer\"," +
            "\"color\": \"RedBlack\"," +
            "\"notes\": \"Special Edition\"" +
            "},\n" +
            "\"category\": 100, \"price\": 1500.50" +
            "}";

    @BeforeEach
    void setUp() throws Exception {

        this.mockMvc.perform(
                post("/user/newUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestSeller));
        this.mockMvc.perform(
                post("/user/newUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestSeller2));
        this.mockMvc.perform(
                post("/user/newUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestCustomer));
        this.mockMvc.perform(
                post("/users/51/follow/50")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(
                post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(post1));
        this.mockMvc.perform(
                post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(post2));
    }

    @AfterEach
    void unfollows() throws Exception{
        this.mockMvc.perform(
                post("/users/51/unfollow/50")).andDo(print()).andExpect(status().isOk());
    }


    //US0005
    @Test
    void newPost() throws Exception {
        this.mockMvc.perform(
                        post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(post3))
                .andExpect(status().isOk());
    }

    //US0006
    @Test
    void getPostList() throws Exception {
        this.mockMvc.perform(
                        get("/products/followed/51/list")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(post1))
                .andExpect(status().isOk())
                .andDo(print()).andExpect(jsonPath("$.posts.[0].id_post").value("18"))
                .andDo(print()).andExpect(jsonPath("$.posts.[1].id_post").value("19"));
    }


    //US0009
    @Test
    void orderPosts() throws Exception {
        this.mockMvc.perform(
                        get("/products/followed/51/list?order=date_desc")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(post1))
                .andExpect(status().isOk())
                .andDo(print()).andExpect(jsonPath("$.posts.[0].id_post").value("18"))
                .andDo(print()).andExpect(jsonPath("$.posts.[1].id_post").value("19"));
        this.mockMvc.perform(
                        get("/products/followed/51/list?order=date_asc")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(post1))
                .andExpect(status().isOk())
                .andDo(print()).andExpect(jsonPath("$.posts.[0].id_post").value("19"))
                .andDo(print()).andExpect(jsonPath("$.posts.[1].id_post").value("18"));
    }
}
