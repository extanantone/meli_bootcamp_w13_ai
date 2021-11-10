package com.bootcamp.EJREPMessengers.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
public class PalomaMensajera extends AMensajero {

    Integer comida = 0;
    LocalDateTime ultimoDescanso = LocalDateTime.now();

    public PalomaMensajera() {
    }

    public PalomaMensajera(String mensaje) {
        super(mensaje);
        super.setMensajeParticular("Grru Rru Gu (Me agarran a mi patita un papelito)");
        super.setTipoMensajero("Paloma");
    }

    @Override
    public String convertirMensaje(String mensaje) {
        if (getMensajeParticular()==null){
            setMensajeParticular("");
        }else {
            LocalDateTime currentTime = LocalDateTime.now();

            Duration diferencia = Duration.between(this.ultimoDescanso, currentTime);
            Long diferenciaHoras = diferencia.toHours();
            if (this.comida > 1 && diferenciaHoras < 1) {
                return "descansando";
            }
            this.comida--;
            this.ultimoDescanso = currentTime;
        }
        return this.getMensajeParticular() + " " + "<<" + mensaje+">>";
    }
}
