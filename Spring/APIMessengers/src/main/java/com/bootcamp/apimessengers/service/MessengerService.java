package com.bootcamp.apimessengers.service;

import com.bootcamp.apimessengers.dto.MessageDTO;
import com.bootcamp.apimessengers.dto.MessengerInfoDTO;
import com.bootcamp.apimessengers.dto.MessengerTypeDTO;
import com.bootcamp.apimessengers.entitiy.Messenger;
import com.bootcamp.apimessengers.exception.NotFoundMessengerException;
import com.bootcamp.apimessengers.repository.IMessengerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessengerService implements IMessengerService{

    final IMessengerRepository messengersRepository;

    public MessengerService(IMessengerRepository messengersRepository) {
        this.messengersRepository = messengersRepository;
    }

    @Override
    public MessageDTO showMessage(Long id, String message) {
        Messenger messenger = messengersRepository.getMessenger(id)
                .orElseThrow(()-> new NotFoundMessengerException(id));

        return new MessageDTO(messenger.getType(), messenger.showMessage(message));
    }

    @Override
    public List<MessengerTypeDTO> getMessengers() {
         List<MessengerTypeDTO> messengers = new ArrayList<>();
         messengersRepository.findAll().stream().forEach((k) -> {
             messengers.add(new MessengerTypeDTO(k.getValue().getType()));
         });
        return messengers;
    }

    @Override
    public MessengerInfoDTO getMessengerInfo(Long id) {
        Messenger messenger = messengersRepository.getMessenger(id)
                .orElseThrow(()-> new NotFoundMessengerException(id));
        return new MessengerInfoDTO(id,messenger.getType());
    }
}
