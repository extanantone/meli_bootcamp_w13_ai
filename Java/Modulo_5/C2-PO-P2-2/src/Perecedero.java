public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
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

        double precioTotal = 0;
        double precioParcial = super.calcular(cantidadDeProductos);

        switch (this.diasPorCaducar){
            case 1:
                precioTotal = precioParcial / 4;
                break;
            case 2:
                precioTotal = precioParcial / 3;
                break;
            default:
                precioTotal = precioParcial / 2;
                break;
        }

        return precioTotal;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
