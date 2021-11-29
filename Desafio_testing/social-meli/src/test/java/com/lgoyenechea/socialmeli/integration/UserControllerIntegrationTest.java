package com.lgoyenechea.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgoyenechea.socialmeli.dto.UserCreationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    final String CONTENT_TYPE = "application/json";
    final String REQUEST_MAPPING = "/users";

    @Test
    void givenUserName_whenNewUser_thenCreated() throws Exception {
        UserCreationDTO dto = new UserCreationDTO("Test");

        MvcResult result = this.mockMvc
                .perform(post(REQUEST_MAPPING)
                        .contentType(CONTENT_TYPE)
                        .content(objectMapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Test"))
                .andReturn();

        assertEquals(CONTENT_TYPE, result.getResponse().getContentType());
    }


}
