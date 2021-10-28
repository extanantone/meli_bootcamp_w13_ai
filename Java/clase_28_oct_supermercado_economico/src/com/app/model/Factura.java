package com.app.model;

import java.util.ArrayList;
import java.util.List;

public class Factura {


    private static int sequenceId = 0;

    private int id;

    private List<Item> items;

    public Factura(){
        id = sequenceId;
        sequenceId++;
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public int getId() {
        return id;
    }

    public int getTotalPrice(){
        return items.stream().
            mapToInt(Item::getTotalPrice).sum();
    }
}
