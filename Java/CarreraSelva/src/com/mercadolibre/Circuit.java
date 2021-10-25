package com.mercadolibre;

import java.util.Arrays;

public class Circuit {

    int id;
    String name;
    int[] inscriptionPrices;
    String description;

    public Circuit(int id, String name, int[] inscriptionPrices, String description) {
        this.id = id;
        this.name = name;
        this.inscriptionPrices = inscriptionPrices;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Circuit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
