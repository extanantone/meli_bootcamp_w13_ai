package com.bootcamp.messengers.service;

import com.bootcamp.messengers.dto.*;
import com.bootcamp.messengers.exceptions.NotFoundException;
import com.bootcamp.messengers.exceptions.RecursosInsuficientesException;
import com.bootcamp.messengers.model.Mensajero;
import com.bootcamp.messengers.model.PalomaMensajera;
import com.bootcamp.messengers.model.TelefonoCelular;
import com.bootcamp.messengers.model.Telegrafo;
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
        if(!mensajero.puedoEnviarMsj()){ //chequea si puede enviar el mensaje
            throw new RecursosInsuficientesException("El mensaje no pudo ser enviado en ID " + mensajero.getId() + " por falta de recursos.");
        }
        MensajeDTO mensaje = new MensajeDTO();
        mensaje.setMensaje(mensajero.emitirMensaje(msj));

        return mensaje;
    }

    public void setEstadoPaloma(PalomaStateDTO paloma){
        PalomaMensajera mensajeroPaloma = (PalomaMensajera) this.messengersRepository.buscarMensajero(paloma.getId());
        if(mensajeroPaloma == null){
            throw new NotFoundException();
        }
        if(paloma.getCant_comida() < 0){
            throw new IllegalArgumentException();
        }
        mensajeroPaloma.setCantComida(paloma.getCant_comida());
    }

    public void setEstadoCelular(CelularStateDTO celular){
        TelefonoCelular mensajeroCelular = (TelefonoCelular) this.messengersRepository.buscarMensajero(celular.getId());
        if(mensajeroCelular == null){
            throw new NotFoundException();
        }
        if(celular.getDatos_internet() < 0 || celular.getPorcentaje_bateria() < 0){
            throw new IllegalArgumentException();
        }
        mensajeroCelular.setDatosInternet(celular.getDatos_internet());
        mensajeroCelular.setPorcentajeBateria(celular.getPorcentaje_bateria());
    }

    public void setEstadoTelegrafo(TelegrafoStateDTO telegrafo){
        Telegrafo mensajeroTelegrafo = (Telegrafo) this.messengersRepository.buscarMensajero(telegrafo.getId());
        if(mensajeroTelegrafo == null){
            throw new NotFoundException();
        }
        mensajeroTelegrafo.setEnchufado(telegrafo.getEnchufado());
    }
}
