public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getdiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setdiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Producto Perecedero: " + "Nombre: " + super.getNombre() + " Precio: " + super.getPrecio() +
                "diasPorCaducar=" + diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precio= super.calcular(cantidadDeProductos);
        double precioFinal= 0.0;
        switch (this.diasPorCaducar){
            case 1:
                precioFinal= precio/4;
                break;
            case 2:
                precioFinal= precio/3;
                break;
            case 3:
                precioFinal= precio/2;
                break;
            default:
                precioFinal= precio;
                break;
        }

        return precioFinal;
    }
}
