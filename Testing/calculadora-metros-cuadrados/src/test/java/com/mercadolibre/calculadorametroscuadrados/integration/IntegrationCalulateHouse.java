package com.mercadolibre.calculadorametroscuadrados.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.unitari.Util;
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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationCalulateHouse {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    HouseResponseDTO house = new HouseResponseDTO();

    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void beforeEach(){

        house.setName("Apartamento");
        house.setRooms(Util.getHouseDTO().getRooms());
        house.setAddress(Util.getHouseDTO().getAddress());
        house.setPrice(20000);
        house.setBiggest(Util.getHouseDTO().getRooms().get(1));
        house.setSquareFeet(16);

    }

    @Test
    public void testCalculatorHousePrice () throws Exception{

        String housejson = writer.writeValueAsString(Util.getHouseDTO());
        String houseResponsejson = writer.writeValueAsString(housejson);

        MvcResult resposnse= this.mockMvc.perform(
                MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON).content(housejson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Apartamento"))
        .andReturn();


        Assertions.assertEquals(houseResponsejson, resposnse.getResponse().getContentAsString());

    }
}
