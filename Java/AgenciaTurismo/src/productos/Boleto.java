package productos;

public class Boleto extends Producto{


    public Boleto(double precio, int tipoProducto, String descripcion) {
        super(precio, tipoProducto, descripcion);
    }

    @Override
    public double calcularDescuento(double desc) {
        return precio-((precio*desc)/100);
    }


}
