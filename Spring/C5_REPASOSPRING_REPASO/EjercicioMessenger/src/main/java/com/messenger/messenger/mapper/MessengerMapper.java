package com.messenger.messenger.mapper;

import com.messenger.messenger.dtos.MessengerDTO;
import com.messenger.messenger.model.Courier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessengerMapper {
    public List<MessengerDTO> CourierListToMessengerDTOList(List<Courier> courierList){
        List<MessengerDTO> messengerDTOList = new ArrayList<MessengerDTO>();
        courierList.forEach(courier -> messengerDTOList.add(new MessengerDTO(courier.getMessengerName())) );
        return messengerDTOList;
    }
}
