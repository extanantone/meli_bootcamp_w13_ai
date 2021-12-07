package com.mercadolibre.linktracker.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.linktracker.dto.LinkDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestLinkController {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @Test
    void createNewLinkFromValidLink() throws Exception {
        LinkDTO payloadDTO = new LinkDTO();
        payloadDTO.setLinkId(2);
        payloadDTO.setLink("https://facebook.com/");
        payloadDTO.setPassword("meli1234");
        String payloadJson = writer.writeValueAsString(payloadDTO);

        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = content().json(payloadJson);
        ResultMatcher expectedStatus = status().isOk();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedContent);
    }

    @Test
    void requestMetricsWithNotFoundIdThenReturnNull() throws Exception {
        Integer idNotFound = 555;

        ResultMatcher expectedContent = content().json("");

        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/{linkId}", idNotFound))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().si)
               // .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               // .andExpect();

    }


}
