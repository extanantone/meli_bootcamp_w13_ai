package Parte2;

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
    public double calcular(int cantidadDeProductos) {

        double precioOriginal=super.calcular(cantidadDeProductos);

        if (diasPorCaducar==1)
        {
            return (precioOriginal/4);
        }
        else {
            if (diasPorCaducar == 2) {
                return (precioOriginal / 3);
            } else {
                if (diasPorCaducar == 3) {
                    return (precioOriginal / 2);
                }
            }
        }
        return precioOriginal;
            }
        }
