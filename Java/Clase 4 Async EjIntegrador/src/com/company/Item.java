package com.company;

public class Item {
    String codigo;
    String nombre;
    Integer cantComprada;
    Double costoUnitario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(Integer cantComprada) {
        this.cantComprada = cantComprada;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Item(String codigo, String nombre, Integer cantComprada, Double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantComprada = cantComprada;
        this.costoUnitario = costoUnitario;
    }
}
