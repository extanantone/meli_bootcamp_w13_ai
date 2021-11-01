package bootcamp.models;

import bootcamp.main.GestorProducto;

public class Producto {

    private int codigo;
    private String nombre;
    private double costoUnitario;


    public Producto(int codigo, String nombre, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;

        GestorProducto.agregarProducto(this);

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

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
