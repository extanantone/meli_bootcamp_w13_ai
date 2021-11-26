package com.mercadolibre.calculadorametroscuadrados.unitari;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
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
    CalculateRestController controller= new CalculateRestController();

    HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
     {
         houseResponseDTO.setBiggest(Util.getHouseDTO().getRooms().get(0));
         houseResponseDTO.setAddress("call77");
        houseResponseDTO.setRooms(Util.getHouseDTO().getRooms());
        houseResponseDTO.setName("Casa");
        houseResponseDTO.setPrice(20000);
        houseResponseDTO.setSquareFeet(200);

    }

    /*@Test
    void calculate(){

        //Arrange


      //  Mockito.when(service.calculate(new HouseDTO())).thenReturn(houseResponseDTO);

        HouseResponseDTO curret = controller.calculate(new HouseDTO());

        Mockito.verify(service, Mockito.atLeast(1));

    }*/

}
