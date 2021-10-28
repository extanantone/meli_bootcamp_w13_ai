package productos;

public class Transporte extends Producto{


    public Transporte(double precio, int tipoProducto, String descripcion) {
        super(precio, tipoProducto, descripcion);
    }

    @Override
    public double calcularDescuento(double desc) {
        return this.precio-((this.precio*desc)/100);
    }
}
