package JAVA.C4.EJIN.Model;

import JAVA.C4.EJIN.Repository.CRUDInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Item {
    private int codigo;
    private String nombre;
    private int cantidadComprada;
    private double costoUnitario;

    public Item(int codigo, String nombre, int cantidadComprada, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Item, " +
                "código: " + codigo +
                ", nombre: " + nombre +
                ", cantidad comprada: " + cantidadComprada +
                ", costo unitario: " + costoUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }


}
