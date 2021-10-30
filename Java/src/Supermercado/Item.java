package Supermercado;

public class Item{
    private int codigo;
    private String nombre;
    private int costo;
    private int cantidad;

    public Item(int codigo, String nombre, int costo, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCosto() {
        return costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", cantidad=" + cantidad +
                '}';
    }
}
