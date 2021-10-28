package com.app.model;

public class Item {

    private int id;

    private static int sequence = 0;

    private String nombre;

    private int quantity;

    private int unitPrice;

    public Item(String nombre,int quantity,int unitPrice){
        sequence++;
        id = sequence;
        this.nombre = nombre;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getTotalPrice(){
        return quantity*unitPrice;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}
