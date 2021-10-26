public class NoPerecedero extends Producto{

    public NoPerecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }

    @Override
    public void setPrecio(double precio) {
        super.setPrecio(precio);
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
