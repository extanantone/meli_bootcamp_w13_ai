package com.bootcamp.messengers.service;

import com.bootcamp.messengers.dto.MensajeDTO;
import com.bootcamp.messengers.dto.MensajeroDTO;
import com.bootcamp.messengers.exceptions.NotFoundException;
import com.bootcamp.messengers.model.Mensajero;
import com.bootcamp.messengers.repository.IMessengersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessengersService implements IMessengersService{
    private IMessengersRepository messengersRepository;

    public MessengersService(IMessengersRepository messengersRepository) {
        this.messengersRepository = messengersRepository;
    }

    @Override
    public List<MensajeroDTO> getMensajeros() {

        List<MensajeroDTO> mensajeros = this.messengersRepository.getMensajeros().stream()
                                            .map(x -> new MensajeroDTO(x.getId(), x.getTipo())).collect(Collectors.toList());

        return mensajeros;
    }

    @Override
    public MensajeDTO getMensaje(Integer id, String msj) {
        Mensajero mensajero = this.messengersRepository.buscarMensajero(id);
        if(mensajero == null){
            throw new NotFoundException("No se ha encontrado un mensajero con ID: " + id);
        }
        MensajeDTO mensaje = new MensajeDTO();
        mensaje.setMensaje(mensajero.emitirMensaje(msj));

        return mensaje;
    }
}
