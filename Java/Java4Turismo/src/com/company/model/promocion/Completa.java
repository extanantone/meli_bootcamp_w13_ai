package com.company.model.promocion;

import com.company.model.item.ItemLocalizador;

import java.util.Map;

public class Completa extends Promocion{

    Map<ItemLocalizador.Type, Integer> cantidadesItems;

    public Completa(Map<ItemLocalizador.Type, Integer> cantidadesItems) {
        super(10);
        this.cantidadesItems = cantidadesItems;
    }

    @Override
    protected boolean cumpleCondicion() {
        for (Integer cantidad:
             this.cantidadesItems.values()) {
            if(cantidad < 1) {
                return false;
            }
        }
        return true;
    }
}
