package objetos;

public class Perecedero extends Producto{
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
    public double calcular(int cantidadDeProductos) {

        double calculo = super.calcular(cantidadDeProductos);

        if (diasPorCaducar == 1){
            calculo = calculo/4;
        } else {
            if (diasPorCaducar == 2){
                calculo = calculo/3;
            } else {
                if (diasPorCaducar == 3){
                    calculo = calculo/2;
                }
            }
        }
        return calculo;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
