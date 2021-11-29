package com.example.socialmeli.integration;

import com.example.socialmeli.dto.DTORequest.DTOproductsRequest;
import com.example.socialmeli.integration.utils.RequestPost.DTORequestPost;
import com.example.socialmeli.integration.utils.RequestPost.JavaToJson;
import com.example.socialmeli.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CreatePost {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    IUserRepository repository;

    @Test
    void createPostWithEmptyBody() throws Exception{
        DTOproductsRequest product = DTORequestPost.getDtoProductRequest();
        createPost(product);
    }

    private void createPost(DTOproductsRequest product) throws Exception {
        JavaToJson.convertJavaToJson(product);
        /*this.mockMvc.perform(post("/products/post"))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content()
                .contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.message").value("Hello World!!!"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));*/
        /*without finish*/
    }


}
