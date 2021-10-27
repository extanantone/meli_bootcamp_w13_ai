public class NoPerecederos extends Producto{

    private String tipo;

    public NoPerecederos(String nombre, double precio, String tipo) {
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
    public String toString() {
        return "NoPerecedero: " + '\n' +
                " - tipo=" + tipo + '\n' +
                " - nombre=" + nombre + '\n' +
                " - precio=" + precio;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }
}
