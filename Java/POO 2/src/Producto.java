public class Producto {
    protected String nombre;
    protected double precio;

    public Producto(){}

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double calcular(int cantidadDeProductos){
        return this.precio * cantidadDeProductos;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Precio: " + this.precio;
    }
}
