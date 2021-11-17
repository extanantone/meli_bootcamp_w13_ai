package POOP2;

public class Perecedero extends Producto {
    int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioParcial = super.calcular(cantidadDeProductos);
        double precioFinal = 0;

        if (diasPorCaducar == 1){
            precioFinal = precioParcial / 4;
        }
        else{
            if (diasPorCaducar == 2){
                precioFinal = precioParcial / 3;
            }
            else{
                precioFinal = precioParcial / 2;
            }
        }

        return precioFinal;
    }
}
