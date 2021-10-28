package com.company.model;

public class Item {
    private Long codigo;
    private String nombre;
    private int cantidad;
    private double costo;

    public Item() {
    }

    public Item(long codigo, String nombre, int cantidad, double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }
}
