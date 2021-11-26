package com.mercadolibre.calculadorametroscuadrados.unitari;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;

import java.util.ArrayList;
import java.util.List;

public class Util {

   public static HouseDTO getHouseDTO(){

        HouseDTO houseDTO = new HouseDTO();
        RoomDTO roomDTO = new RoomDTO();
        List<RoomDTO> roomDTOS = new ArrayList<>();
        roomDTO.setName("Cuarto");
        roomDTO.setLength(3);
        roomDTO.setWidth(3);
        roomDTOS.add(roomDTO);
        roomDTO = new RoomDTO();
        roomDTO.setName("sala");
        roomDTO.setLength(4);
        roomDTO.setWidth(4);
        roomDTOS.add(roomDTO);
        houseDTO.setName("Apartamento");
        houseDTO.setAddress("Calle 77d");
        houseDTO.setRooms(roomDTOS);


        return houseDTO;
    }
}
