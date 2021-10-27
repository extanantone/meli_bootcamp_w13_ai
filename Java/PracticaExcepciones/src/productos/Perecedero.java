package productos;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public double calcular() {
        double nuevoPrecio = 0.0;
        if (diasPorCaducar == 1) {
            nuevoPrecio = this.getPrecio()/4;
        } else if (diasPorCaducar == 2) {
            nuevoPrecio = this.getPrecio()/3;
        } else if (diasPorCaducar == 3) {
            nuevoPrecio = this.getPrecio()/2;
        } else {
            nuevoPrecio = this.getPrecio();
        }
        return nuevoPrecio;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
