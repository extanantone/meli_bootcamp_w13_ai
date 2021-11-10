package com.bootcamp.EJREPMessengers.mapper;

import com.bootcamp.EJREPMessengers.dto.AMensajeroDTO;
import com.bootcamp.EJREPMessengers.model.AMensajero;
import com.bootcamp.EJREPMessengers.model.PalomaMensajera;
import com.bootcamp.EJREPMessengers.model.TelefonoCelular;
import com.bootcamp.EJREPMessengers.model.Telegrafo;
import org.springframework.stereotype.Component;

@Component
public class MensajeroMapper {
    public AMensajeroDTO mensajeroAMensajeroDTO(AMensajero mensajero) {
        AMensajeroDTO mensajeroDTO = new AMensajeroDTO();
        mensajeroDTO.setMensaje(mensajero.getMensaje());
        mensajeroDTO.setTipoMensajero(mensajero.getTipoMensajero());
        return mensajeroDTO;
    }

    public AMensajero mensajeroDTOAMensajero(String tipoMensajero, AMensajeroDTO aMensajeroDTO) {
        AMensajero aMensajero;
        if (tipoMensajero.equals("Paloma")) {
            aMensajero = new PalomaMensajera(aMensajeroDTO.getMensaje());
        } else if (tipoMensajero.equals("Telefono")) {
            aMensajero = new TelefonoCelular(aMensajeroDTO.getMensaje());
        } else if (tipoMensajero.equals("Telegrafo")) {
            aMensajero = new Telegrafo(aMensajeroDTO.getMensaje());
        } else {
            aMensajero = null;
        }
        if (aMensajero != null) {
            aMensajero.setTipoMensajero(aMensajeroDTO.getTipoMensajero());
            aMensajero.setMensaje(aMensajeroDTO.getMensaje());
        }
        return aMensajero;
    }
}
