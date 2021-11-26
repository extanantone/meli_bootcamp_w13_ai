package com.mercadolibre.calculadorametroscuadrados.unitari;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();


    @Test
    void whenCaulculateThenpriceHuouse(){

        //act & Arrange
        HouseResponseDTO curret =calculateService.calculate(Util.getHouseDTO());

        //assert
        Assertions.assertEquals(20000,curret.getPrice());

    }

    @Test
    void whenCaulculateThenbiggets(){

        //Arange
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setWidth(4);
        roomDTO.setLength(4);
        roomDTO.setName("sala");

        //act & Arrange
        HouseResponseDTO curret =calculateService.calculate(Util.getHouseDTO());

        //assert
        Assertions.assertEquals(roomDTO.getName(),curret.getBiggest().getName());

    }
    @Test
    void whenRoomDTOgetSquareFeetThen(){

        //Arange
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setWidth(4);
        roomDTO.setLength(4);
        roomDTO.setName("sala");

        //act Assert
        Assertions.assertEquals(16,roomDTO.getSquareFeet());

    }
}
