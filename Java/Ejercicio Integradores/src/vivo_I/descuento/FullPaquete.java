package vivo_I.descuento;

import vivo_I.Localizador;

public class FullPaquete extends Descuento{
    @Override
    public boolean validarDescuento(Localizador localizador) {
        if(localizador.getReservas().size() == 4 ) {
            return localizador.getReservas().get("1").size() > 0 &&
                    localizador.getReservas().get("2").size() > 0 &&
                    localizador.getReservas().get("3").size() > 0 &&
                    localizador.getReservas().get("4").size()>0;
        }

        return false;

    }

    @Override
    public Double retornarDescuento() {
        return 10D;
    }
}
