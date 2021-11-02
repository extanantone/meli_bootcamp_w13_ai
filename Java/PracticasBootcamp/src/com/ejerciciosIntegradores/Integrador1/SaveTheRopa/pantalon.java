package com.ejerciciosIntegradores.Integrador1.SaveTheRopa;

public class pantalon extends Prenda {

  private String nombre;

    public pantalon(String marca, String modelo, String nombre) {
        super(marca, modelo);
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "pantalon{" +
                "nombre=" + nombre  +" Marca ="+super.getMarca()+" Modelo="+super.getModelo()+
                '}';
    }
}
