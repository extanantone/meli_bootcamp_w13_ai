package ejercicio2;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    @Override
    double calcular(int cantidadDeProductos) {
        //manejar los dias por caducar.
        return this.reducirPrecio(cantidadDeProductos * this.getPrecio());
    }

    public double reducirPrecio(double total) {
        if( this.getDiasPorCaducar() == 1 ) {
            total = (total-(this.getPrecio()*3));
        }else {
            if( this.getDiasPorCaducar() == 2 ) {
                total = (total-(this.getPrecio()*2));
            } else {
                if ( this.getDiasPorCaducar() == 3 ) {
                    total = (total-(this.getPrecio()*0.5));
                }
            }
        }
        return total;
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
