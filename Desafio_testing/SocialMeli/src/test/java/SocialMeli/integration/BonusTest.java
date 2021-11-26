package SocialMeli.integration;

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
public class BonusTest {

    @Autowired
    private MockMvc mockMvc;

    String requestSeller1 = "{\"user_id\": 50,\"user_name\": \"testSellera\",\"seller\": true}";
    String requestSeller2 = "{\"user_id\": 60,\"user_name\": \"testSellerb\",\"seller\": true}";

    String postPromo1 = "{\n" +
            "\"user_id\": 50, \"id_post\": 40,\n" +
            "\"date\": \"29-04-2021\", \"detail\": {\n" +
            "\"product_id\": 1, \"product_name\": \"Silla Gamer\", \"type\": \"Gamer\",\n" +
            "\"brand\": \"Racer\",\n" +
            "\"color\": \"RedBlack\",\n" +
            "\"notes\": \"Special Edition\"\n" +
            "},\n" +
            "\"category\": \"100\", \"price\": 1500.5, \"has_promo\": true, \"discount\": 0.25\n" +
            "}";

    String postPromo2 = "{\n" +
            "\"user_id\": 50, \"id_post\": 41,\n" +
            "\"date\": \"29-04-2021\", \"detail\": {\n" +
            "\"product_id\": 1, \"product_name\": \"Silla Gamer\", \"type\": \"Gamer\",\n" +
            "\"brand\": \"Racer\",\n" +
            "\"color\": \"RedBlack\",\n" +
            "\"notes\": \"Special Edition\"\n" +
            "},\n" +
            "\"category\": \"100\", \"price\": 1500.5, \"has_promo\": true, \"discount\": 0.25\n" +
            "}";

    String postPromo3 = "{\n" +
            "\"user_id\": 60, \"id_post\": 22,\n" +
            "\"date\": \"29-04-2021\", \"detail\": {\n" +
            "\"product_id\": 1, \"product_name\": \"Silla Gamer\", \"type\": \"Gamer\",\n" +
            "\"brand\": \"Racer\",\n" +
            "\"color\": \"RedBlack\",\n" +
            "\"notes\": \"Special Edition\"\n" +
            "},\n" +
            "\"category\": \"100\", \"price\": 1500.5, \"has_promo\": true, \"discount\": 0.25\n" +
            "}";

    @BeforeEach
    void setUp() throws Exception {
        this.mockMvc.perform(
                post("/user/newUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestSeller1));
        this.mockMvc.perform(
                post("/user/newUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestSeller2));
        this.mockMvc.perform(
                post("/products/promopost")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postPromo1));
        this.mockMvc.perform(
                post("/products/promopost")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postPromo2));
    }
    //BONUS

    //US0010
    @Test
    void newPromoPost() throws Exception {
        this.mockMvc.perform(
                        post("/products/promopost")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(postPromo3))
                .andExpect(status().isOk());
    }


    //US0011
    @Test
    void promoPostCount() throws Exception {
        this.mockMvc.perform(
                        get("/products/50/promo-post/count"))
                .andExpect(status().isOk())
                .andDo(print()).andExpect(jsonPath("$.promo_products_count").value("2"));
    }


    //US0012
    @Test
    void promoPostList() throws Exception {
        this.mockMvc.perform(
                        get("/products/50/list"))
                .andExpect(status().isOk())
                .andDo(print()).andExpect(jsonPath("$.posts.[0].id_post").value("40"))
                .andDo(print()).andExpect(jsonPath("$.posts.[1].id_post").value("41"));
    }
}
