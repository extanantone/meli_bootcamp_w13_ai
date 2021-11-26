package com.mercadolibre.calculadorametroscuadrados.unitTest;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculateServiceTest {

    CalculateService service = new CalculateService();

    private static HouseDTO house = new HouseDTO();
    private static List<RoomDTO> rooms = new ArrayList<>();

    @BeforeAll
    public static void createHouse() {

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

        house.setName("house1");
        house.setAddress("calle1");
        house.setRooms(rooms);
    }


    @Test
    @DisplayName("When price is correct")
    void test1() {
        // Arrange
        Integer priceExpect = 60800;
        // Act
        HouseResponseDTO current = service.calculate(house);

        // Assert
        Assertions.assertEquals(priceExpect,current.getPrice());

    }

    @Test
    @DisplayName("When the biggest room is correct")
    void test2() {

        HouseResponseDTO current = service.calculate(house);

        Assertions.assertAll(
                () -> Assertions.assertEquals(rooms.get(1).getName(),current.getBiggest().getName()),
                () -> Assertions.assertEquals(rooms.get(1).getSquareFeet(),current.getBiggest().getSquareFeet())
        );
    }

    @Test
    @DisplayName("Validate Squarefeet per Room")
    void test3() {

        HouseResponseDTO current = service.calculate(house);

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(rooms.get(0).getSquareFeet(),current.getRooms().get(0).getSquareFeet()),
                () -> Assertions.assertEquals(rooms.get(1).getSquareFeet(),current.getRooms().get(1).getSquareFeet())
        );

    }
}
