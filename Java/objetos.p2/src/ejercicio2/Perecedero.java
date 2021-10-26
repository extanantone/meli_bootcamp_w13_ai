package ejercicio2;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    @Override
    double calcular(int cantidadDeProductos) {
        //manejar los dias por caducar.
        return (cantidadDeProductos * this.getPrecio());
    }

    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }

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
}
