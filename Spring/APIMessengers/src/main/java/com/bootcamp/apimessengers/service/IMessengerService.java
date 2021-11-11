package com.bootcamp.apimessengers.service;

import com.bootcamp.apimessengers.dto.MessageDTO;
import com.bootcamp.apimessengers.dto.MessengerInfoDTO;
import com.bootcamp.apimessengers.dto.MessengerTypeDTO;

import java.util.List;

public interface IMessengerService {

    MessageDTO showMessage(Long id,String message);

    List<MessengerTypeDTO> getMessengers();

    MessengerInfoDTO getMessengerInfo(Long id);

}
