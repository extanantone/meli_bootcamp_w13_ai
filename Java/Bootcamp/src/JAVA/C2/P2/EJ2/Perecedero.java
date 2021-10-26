package JAVA.C2.P2.EJ2;

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
        return super.toString() + "\n" +
                "Dias por caducar: " + diasPorCaducar;
    }


    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos);
        switch (cantidadDeProductos){
            case 1:
                return precioFinal/4;
            case 2:
                return  precioFinal/3;
            case 3:
                return precioFinal/2;
            default:
                return precioFinal;
        }
    }


}
