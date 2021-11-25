package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    static HouseDTO houseDTO = new HouseDTO();

    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void setearDatosDePrueba(){

        houseDTO.setName("Caseron");
        houseDTO.setAddress("Siemprebuena 9012");

        RoomDTO roomDTO1 = new RoomDTO();
        roomDTO1.setName("Cocina");
        roomDTO1.setLength(4);
        roomDTO1.setWidth(3);

        RoomDTO roomDTO2 = new RoomDTO();
        roomDTO2.setName("Living");
        roomDTO2.setLength(4);
        roomDTO2.setWidth(5);

        RoomDTO roomDTO3 = new RoomDTO();
        roomDTO3.setName("Pieza");
        roomDTO3.setLength(2);
        roomDTO3.setWidth(3);

        RoomDTO roomDTO4 = new RoomDTO();
        roomDTO4.setName("Baño");
        roomDTO4.setLength(2);
        roomDTO4.setWidth(2);

        List<RoomDTO> roomDTOList = new LinkedList<>();
        roomDTOList.add(roomDTO1);
        roomDTOList.add(roomDTO2);
        roomDTOList.add(roomDTO3);
        roomDTOList.add(roomDTO4);

        houseDTO.setRooms(roomDTOList);
        // Espacio cubierto : 42
        // Valor : 33600
        // Pieza mas grande : Living
    }

    @Test
    public void testStandartHouse() throws  Exception{

        String houseDTOString = writer.writeValueAsString(houseDTO);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(houseDTOString)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(33600))
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareFeet").value(42))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggest.name").value("Living"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggest.squareFeet").value(20))

                .andReturn();
    }
}
