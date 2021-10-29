package vivo_I.descuento;

import vivo_I.Localizador;

public abstract class Descuento {



    public Double aplicardescuento(Localizador localizador) {

        if(validarDescuento(localizador)) {

            return localizador.getTotal()*retornarDescuento()/100;
        }

        return 0D;

    }
    public abstract boolean validarDescuento(Localizador localizador);

    public abstract Double retornarDescuento();
}
