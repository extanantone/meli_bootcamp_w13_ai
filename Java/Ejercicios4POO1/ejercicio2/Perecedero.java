package ejercicio2;

public class Perecedero extends Producto{

    private int diasPorCaducar;


    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        switch (this.diasPorCaducar){
            case 1:
                super.setPrecio(super.getPrecio()/4);
                break;

            case 2:
                super.setPrecio(super.getPrecio()/3);
                break;

            case 3:
                super.setPrecio(super.getPrecio()/2);
                break;
            default:
                break;
        }

        double calcularPadre = super.calcular(cantidadDeProductos);

        return calcularPadre;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return super.toString() +
                " , diasPorCaducar : " + diasPorCaducar;
    }
}
