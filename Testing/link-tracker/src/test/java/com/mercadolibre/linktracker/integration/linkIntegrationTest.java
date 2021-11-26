package com.mercadolibre.linktracker.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc

public class linkIntegrationTest {
    @Autowired
    public MockMvc mockMvc;

    static LinkRepositoryImpl linkRepositoryImpl;

    private static ObjectWriter writer;
    private static ObjectMapper mapper;

    LinkDTO link;

    @BeforeAll
    public static void setUp() {
        linkRepositoryImpl = new LinkRepositoryImpl();
        mapper = new ObjectMapper();
        writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }


}


//    @Test
//    public void testHelloPostGeorgeOutput() throws Exception {
//        NameDTO payloadDTO = new NameDTO("George");
//        HelloDTO responseDTO = new HelloDTO(1, "Hello George!");
//
//        ObjectWriter writer = new ObjectMapper()
//                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
//                .writer();
//
//        String payloadJson = writer.writeValueAsString(payloadDTO);
//        String responseJson = writer.writeValueAsString(responseDTO);
//
//
//        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/sayHelloPost")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(payloadJson))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(content().contentType("application/json"))
//                .andReturn();
//
//        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
//    }



