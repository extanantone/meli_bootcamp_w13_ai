package Productos;

public class Producto {
    String nombre;
    double precio;

    public Producto(String inNombre, double inPrecio) {
        this.nombre = inNombre;
        this.precio = inPrecio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String inNombre) {
        this.nombre = inNombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double inPrecio) {
        this.precio = inPrecio;
    }

    @Override
    public String toString() {
        return String.format("+ Nombre: %s\n+ Precio: %f", this.nombre, this.precio);
    }

    public double calcular(int cantidadDeProductos) {
        return this.precio*cantidadDeProductos;
    }
}
