package com.company.model.promocion;

import com.company.model.item.ItemLocalizador;

import java.util.List;

public class HotelX2 extends Promocion {
    List<ItemLocalizador> items;

    public HotelX2(List<ItemLocalizador> items) {
        super(5);
        this.items = items;
    }

    @Override
    protected boolean cumpleCondicion() {
        return items.stream()
                .filter(x -> x.getType() == ItemLocalizador.Type.reserva)
                .count() == 2;
    }
}
