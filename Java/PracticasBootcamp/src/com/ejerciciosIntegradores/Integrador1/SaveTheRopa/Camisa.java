package com.ejerciciosIntegradores.Integrador1.SaveTheRopa;

public class Camisa extends Prenda{

   private  String nombre;

    public Camisa(String marca, String modelo, String nombre) {
        super(marca, modelo);
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Camisa{" +
                "nombre=" + nombre  +" Marca ="+super.getMarca()+" Modelo="+super.getModelo()+
                "} " ;
    }
}
