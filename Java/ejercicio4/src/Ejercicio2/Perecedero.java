package Ejercicio2;

public class Perecedero extends Producto {
    private int diasPorCalcular;

    public Perecedero(String nombre, double precio, int diasPorCalcular) {
        super(nombre, precio);
        this.diasPorCalcular = diasPorCalcular;
    }

    public int getDiasPorCalcular() {
        return diasPorCalcular;
    }

    public void setDiasPorCalcular(int diasPorCalcular) {
        this.diasPorCalcular = diasPorCalcular;
    }

    @Override
    public String toString() {
        return "Ejercicio2.Perecedero {" +
                "diasPorCalcular=" + diasPorCalcular +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precio = super.calcular(cantidadDeProductos);
        if (diasPorCalcular == 1) return precio/4;
        if (diasPorCalcular == 2) return precio/3;
        if (diasPorCalcular == 3) return precio/2;
        return precio;
    }
}
