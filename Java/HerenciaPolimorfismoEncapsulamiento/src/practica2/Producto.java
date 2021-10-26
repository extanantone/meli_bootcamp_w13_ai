package practica2;

public class Producto {
    String nombre;
    double precio;

    public String getNombre() {
        return nombre;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "Producto: " + nombre + " Precio: " + precio;
    }

    public double calcular(int cantidadDeProductos){
        return cantidadDeProductos * precio;
    }
}
