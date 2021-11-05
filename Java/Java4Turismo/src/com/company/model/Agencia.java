package com.company.model;

import com.company.model.item.ItemLocalizador;
import com.company.model.promocion.Completa;
import com.company.model.promocion.HotelX2;
import com.company.model.promocion.LocalizadorX2;
import com.company.model.promocion.Promocion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agencia {
    static public Map<ItemLocalizador.Type, Integer> calcularTipoItems(
            List<ItemLocalizador> items) {

        Map<ItemLocalizador.Type, Integer> cantidades = new HashMap<>();

        for (ItemLocalizador.Type type:
                ItemLocalizador.Type.values()) {
            cantidades.put(type, 0);
        }

        for (ItemLocalizador item:
             items) {
            Integer cantidad = cantidades.get( item.getType() );
            cantidades.put( item.getType(), cantidad+1 );
        }
        return cantidades;
    }


    public static List<Promocion> getPromociones(
            Cliente cliente,
            Paquete paquete) {
        return List.of(
                new Completa(paquete.getItemsTipo()),
                new HotelX2(paquete.getItems()),
                new LocalizadorX2(cliente.getLocalizadores())
        );
    }
}
