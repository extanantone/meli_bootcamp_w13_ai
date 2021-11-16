package com.bootcamp.Mensajero.model;

public class Telegrafo implements Mensajero {

    String convertirAMorse(String msg){
        return "Pippippi <<"+msg+">>";
    }

    @Override
    public String emitirMensaje(String msg) {
        return convertirAMorse(msg);
    }

    @Override
    public String getType() {
        return "Telegrafo";
    }
}
