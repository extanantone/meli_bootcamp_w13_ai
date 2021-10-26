package ejercicio2;

public class NoPerecedero extends Producto{
    private String tipo;

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    double calcular(int cantidadDeProductos) {
        return (cantidadDeProductos * this.getPrecio());
    }

    public NoPerecedero(String nombre, double precio) {
        super(nombre, precio);
    }
}
