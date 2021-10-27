package com.factura.model;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private List<Item> items;
    public Factura(){
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    @Override
    public String toString() {
        return "\nFactura{\nitems:"+items.toString()+"\n]";
    }
}
