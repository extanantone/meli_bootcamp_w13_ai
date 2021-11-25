package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {

    @InjectMocks
    CalculateService service;

    static HouseDTO houseDTO = new HouseDTO();
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
    void calculateValue33600() {
        HouseResponseDTO houseResponseDTO = service.calculate(houseDTO);
        Integer expectedValue = 33600;

        Assertions.assertEquals(expectedValue, houseResponseDTO.getPrice());
    }

    @Test
    void calculateTotalSquareFeet42() {
        HouseResponseDTO houseResponseDTO = service.calculate(houseDTO);
        Integer expectedValue = 42;

        Assertions.assertEquals(expectedValue, houseResponseDTO.getSquareFeet());
    }

    @Test
    void calculateBiggestRoomLiving() {
        HouseResponseDTO houseResponseDTO = service.calculate(houseDTO);
        String expectedValueName = "Living";
        Integer expectedSquareFeet = 20;

        Assertions.assertEquals(expectedValueName, houseResponseDTO.getBiggest().getName());
        Assertions.assertEquals(expectedSquareFeet, houseResponseDTO.getBiggest().getSquareFeet());
    }

    @Test
    void noRoomsHouse() {
        HouseDTO houseDTOWithoutRooms = new HouseDTO();
        houseDTOWithoutRooms.setRooms(new LinkedList<>());

        HouseResponseDTO houseResponseDTO = service.calculate(houseDTOWithoutRooms);
        RoomDTO exceptedBiggestRoom = null;
        Integer expectedSquareFeet = 0;

        Assertions.assertEquals(exceptedBiggestRoom, houseResponseDTO.getBiggest());
        Assertions.assertEquals(expectedSquareFeet, houseResponseDTO.getSquareFeet());
    }

    @Test
    void houseWithSameRoomsSize() {
        HouseDTO houseDTOWithSameRoomSize = new HouseDTO();

        RoomDTO roomDTO1 = new RoomDTO();
        roomDTO1.setName("Cocina");
        roomDTO1.setLength(3);
        roomDTO1.setWidth(3);

        RoomDTO roomDTO2 = new RoomDTO();
        roomDTO2.setName("Living");
        roomDTO2.setLength(3);
        roomDTO2.setWidth(3);


        RoomDTO roomDTO3 = new RoomDTO();
        roomDTO3.setName("Baño");
        roomDTO3.setLength(1);
        roomDTO3.setWidth(1);

        List<RoomDTO> roomDTOList = new LinkedList<>();
        roomDTOList.add(roomDTO1);
        roomDTOList.add(roomDTO2);
        roomDTOList.add(roomDTO3);

        houseDTOWithSameRoomSize.setRooms(roomDTOList);

        HouseResponseDTO houseResponseDTO = service.calculate(houseDTOWithSameRoomSize);
        String exceptedBiggestRoomName = "Cocina";
        String exceptedBiggestRoomName2 = "Living";
        Integer expectedSquareFeet = 0;

        Assertions.assertTrue(houseResponseDTO.getBiggest().getName().equals(exceptedBiggestRoomName) || houseResponseDTO.getBiggest().getName().equals(exceptedBiggestRoomName2) );
    }

}