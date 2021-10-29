package vivo_I.descuento;

import vivo_I.Localizador;

public class ReservaBoleto extends Descuento{


    @Override
    public boolean validarDescuento(Localizador localizador) {
        if(localizador.getReservas().containsKey("1") && localizador.getReservas().containsKey("2")) {
            return localizador.getReservas().get("1").size() >= 2 && localizador.getReservas().get("2").size() >= 2;
        }
        return false;

    }

    @Override
    public Double retornarDescuento() {
        return 5D;
    }
}
