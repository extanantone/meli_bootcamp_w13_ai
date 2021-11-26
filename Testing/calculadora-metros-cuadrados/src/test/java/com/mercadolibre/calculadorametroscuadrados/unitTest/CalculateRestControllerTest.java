package com.mercadolibre.calculadorametroscuadrados.unitTest;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;



import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController restController;

    private static HouseDTO house = new HouseDTO();
    private static List<RoomDTO> rooms = new ArrayList<>();

    @BeforeAll
    public static void createHouse() {

        house.setName("house1");
        house.setAddress("calle1");

        RoomDTO room1 = new RoomDTO();
        room1.setName("room1");
        room1.setLength(5);
        room1.setWidth(4);


        RoomDTO room2 = new RoomDTO();
        room2.setName("room2");
        room2.setLength(8);
        room2.setWidth(7);


        rooms.add(room1);
        rooms.add(room2);

        house.setRooms(rooms);
    }

    @Test
    @DisplayName("name")
    void name() {

        // Arrange

        HouseResponseDTO houseResponse = new HouseResponseDTO(house);

        houseResponse.setBiggest(rooms.get(1));
        houseResponse.setSquareFeet(76);
        houseResponse.setPrice(60800);

        Mockito.when(service.calculate(house)).thenReturn(houseResponse);

        // ACT

        HouseResponseDTO current = restController.calculate(house);

        // Assert
        Mockito.verify(service,Mockito.atLeastOnce()).calculate(house);
        Assertions.assertEquals(houseResponse.getBiggest(),current.getBiggest());

    }
}
