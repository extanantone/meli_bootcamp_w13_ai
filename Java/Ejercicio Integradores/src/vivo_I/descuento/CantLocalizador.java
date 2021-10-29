package vivo_I.descuento;

import vivo_I.Localizador;

public class CantLocalizador extends Descuento{



    @Override
    public boolean validarDescuento(Localizador localizador) {
        System.out.println(localizador.getNroLocalizador());
        return localizador.getNroLocalizador() >= 2;
    }

    @Override
    public Double retornarDescuento() {
        return 5D;
    }
}
