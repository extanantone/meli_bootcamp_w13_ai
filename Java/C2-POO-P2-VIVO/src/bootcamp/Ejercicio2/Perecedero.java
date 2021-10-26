package bootcamp.Ejercicio2;

public class Perecedero extends Producto{

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
    protected double calcular(int cantidadDeProductos){

        double valor_total = super.calcular(cantidadDeProductos);
        double precioReducido;

        if(this.getDiasPorCaducar() == 1)
            precioReducido = valor_total/4;
        else if(this.getDiasPorCaducar() == 2)
            precioReducido = valor_total/3;
        else if(this.getDiasPorCaducar() == 3)
            precioReducido = valor_total/2;
        else
            precioReducido=valor_total;


    return precioReducido;
    }


}
