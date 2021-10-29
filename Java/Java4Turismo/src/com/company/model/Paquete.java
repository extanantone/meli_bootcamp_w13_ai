package com.company.model;

import com.company.model.item.ItemLocalizador;

import java.util.List;
import java.util.Map;

public class Paquete {
    List<ItemLocalizador> items;
    Map<ItemLocalizador.Type, Integer> itemsTipo;

    public Paquete(List<ItemLocalizador> items) {
        this.items = items;
        this.itemsTipo = Agencia.calcularTipoItems(items);
    }

    public void addItem(ItemLocalizador item) {
        this.items.add(item);
        this.itemsTipo = Agencia.calcularTipoItems(this.items);
    }

    public List<ItemLocalizador> getItems() {
        return items;
    }

    public Map<ItemLocalizador.Type, Integer> getItemsTipo() {
        return itemsTipo;
    }
}
