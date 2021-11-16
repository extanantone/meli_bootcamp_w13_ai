package com.messenger.messenger.service;

import com.messenger.messenger.dtos.MessengerDTO;
import com.messenger.messenger.mapper.MessengerMapper;
import com.messenger.messenger.repository.MessengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessengerService implements MessengerServiceI{
    @Autowired
    MessengerRepository messengerRepository;

    @Autowired
    MessengerMapper messengerMapper;

    @Override
    public List<MessengerDTO> showMessengers() {
        return messengerMapper.CourierListToMessengerDTOList(messengerRepository.getMessengerList());
    }
}
