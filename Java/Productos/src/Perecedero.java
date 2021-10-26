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

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadProductos){

        double precioBase = super.calcular(cantidadProductos);

        double reduccion = 0;

        if(diasPorCaducar == 1)
            reduccion = 0.25;
        else if( diasPorCaducar == 2)
            reduccion = 0.33;
        else
            reduccion = 0.5;
        return  precioBase * reduccion;
    }
}
