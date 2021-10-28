package productos;

public class Comida extends Producto{


    public Comida(double precio, int tipoProducto, String descripcion) {
        super(precio, tipoProducto, descripcion);
    }

    @Override
    public double calcularDescuento(double desc) {
        return this.precio-((this.precio*desc)/100);
    }

}
