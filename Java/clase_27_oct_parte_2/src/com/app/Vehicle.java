package com.app;

public class Vehicle {

    private String marca;
    private String modelo;
    private int precio;

    public Vehicle(String marca,String modelo,int precio){
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
    
    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Vehiculo{\nmarca:"+marca+"\nmodelo:"+modelo+"\nprecio:"+precio+"\n}";
    }

}
