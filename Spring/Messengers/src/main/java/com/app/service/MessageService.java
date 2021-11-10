package com.app.service;

import com.app.dto.MenssageDto;
import com.app.dto.MessengerDto;
import com.app.exception.MenssengerNotFoundException;
import com.app.model.Messenger;
import com.app.repository.IMessengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService implements IMessengerService{

    private IMessengerRepository iMessengerRepository;

    public MessageService(IMessengerRepository iMessengerRepository){
        this.iMessengerRepository = iMessengerRepository;
    }

    @Override
    public List<MessengerDto> getAllMessengers() {
        return iMessengerRepository.getMessengers().stream()
                .map(i->new MessengerDto(i.getId(),i.message("Hola mundo"))).collect(Collectors.toList());
    }

    @Override
    public MenssageDto getMensageById(int id,String menssage) {
        Messenger messenger = iMessengerRepository.getMenssengerById(id);
        if(messenger==null)
            throw new MenssengerNotFoundException("No existe recurso");
        return new MenssageDto(messenger.message(menssage));
    }
}
