package com.ejerciciosIntegradores.Integrador1.modelAgenciaTurismo;

import com.ejerciciosIntegradores.Integrador1.Interfaces.IReserva;

public class PaqueteBase implements IReserva {

    protected Double precio;
    private String nombre;

    public PaqueteBase(double precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public double getPrecio() {
      return  this.precio;
    }

    @Override
    public String getDetalle() {
        return "Su paquete "+this.nombre;
    }

    @Override
    public String getCompra() {
        return "";
    }

}
