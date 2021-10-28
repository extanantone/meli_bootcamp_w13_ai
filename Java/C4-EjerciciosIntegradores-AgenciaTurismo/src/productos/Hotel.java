package productos;

public class Hotel extends Producto{


    public Hotel(double precio, int tipoProducto, String descripcion) {
        super(precio, tipoProducto, descripcion);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "precio=" + precio +
                '}';
    }

    @Override
    public double calcularDescuento(double desc){
        return this.precio-((this.precio*desc)/100);
    }
}
