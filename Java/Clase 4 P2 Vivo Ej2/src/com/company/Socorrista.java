package com.company;

public class Socorrista<T extends Vehiculo> {
    public void socorrer(T tipoVehiculo){
        System.out.println("Estoy socorriendo a " + tipoVehiculo.soyUn());
    }
}
