package com.app.service;

import com.app.dto.*;
import com.app.exception.NotFoundItem;
import com.app.model.Messenger;
import com.app.model.Paloma;
import com.app.model.TelefonoCelular;
import com.app.model.Telegrafo;
import com.app.repository.IMessengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessengerService implements IMessengerService{

    private IMessengerRepository iMessengerRepository;

    public MessengerService(IMessengerRepository iMessengerRepository){
        this.iMessengerRepository=iMessengerRepository;
    }

    @Override
    public List<MessengerDto> getMessegers() {
        return iMessengerRepository.getMessengers().stream()
                .map(i->new MessengerDto(i.getId())).collect(Collectors.toList());
    }

    @Override
    public MessageDto getMessageDto(int id, String ms) {
        Messenger messenger = iMessengerRepository.getMessengerById(id);
        if(messenger==null)
            throw new NotFoundItem("No se encontro mensajero");
        return new MessageDto(messenger.getId(),messenger.menssage(ms));
    }

    @Override
    public void updatePalomaDto(int id, PalomaDto paloma) {
        Paloma p = iMessengerRepository.getPalomaById(id);
        if(p==null)
            throw new NotFoundItem("No existe paloma");
        p.setComida(p.getComida()+paloma.getComida());
        p.setTiempoDescanzo(p.getTiempoDescanzo()+paloma.getTiempoDescanzo());
        iMessengerRepository.updatePaloma(p);
    }

    @Override
    public void updateTelefono(int id, CellDto dto) {
        TelefonoCelular telefonoCelular = iMessengerRepository.findTelefonoById(id);
        if(telefonoCelular==null)
            throw new NotFoundItem("No existe telefono");
        telefonoCelular.setBateria(telefonoCelular.getBateria()+dto.getBateria());
        telefonoCelular.setDatos(telefonoCelular.getDatos()+dto.getDatos());
        iMessengerRepository.updateTelefono(telefonoCelular);
    }

    @Override
    public void updateTelegrafo(int id,TelegrafoDto dto) {
        Telegrafo telegrafo = iMessengerRepository.getTelegrafoById(id);
        if(telegrafo==null)
            throw new NotFoundItem("No existe telegrafo");
        telegrafo.setListen(dto.isListen());
        iMessengerRepository.updateTelegrafo(telegrafo);
    }
}
