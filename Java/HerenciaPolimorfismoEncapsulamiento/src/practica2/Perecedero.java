package practica2;

public class Perecedero extends Producto {
    int diasPorCaducar;

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

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double value = super.calcular(cantidadDeProductos);

        if (diasPorCaducar == 1){
            return value / 4;
        } else if ( diasPorCaducar == 2  ) {
            return value / 3;
        } else if ( diasPorCaducar ==  3) {
            return value / 2;
        }
        return value;
    }
}
