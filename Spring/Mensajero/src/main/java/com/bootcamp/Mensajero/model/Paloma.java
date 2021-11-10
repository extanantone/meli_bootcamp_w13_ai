package com.bootcamp.Mensajero.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paloma extends MensajeroAbstracto{
    private int comida;
    private int horasSuenio;
    public Paloma(String tipo, int comida, int horas) {
        super("Grru Rru Gu (Me agarran a mi patita un papelito) <<",tipo);
        this.comida = comida;
        this.horasSuenio = horas;
    }
    public void comer(){

    }
    public void descansar(){

    }
}
