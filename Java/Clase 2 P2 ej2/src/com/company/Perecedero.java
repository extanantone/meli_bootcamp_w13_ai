package com.company;

public class Perecedero extends Producto{
    int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero >>> " +
                "Dias por caducar : " + diasPorCaducar +
                ", Nombre : " + nombre +
                ", Precio : $" + precio;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    double calcular(int cantidadDeProductos){
        // Reutilizado la operacion del padre para la cantidad por el precio
        double primerTotal = super.calcular(cantidadDeProductos);
        double resultado;
        // Segun los dias
        switch (diasPorCaducar){
            // Reduzco 4 veces el precio
            case(1):{
                resultado = primerTotal * 0.25;
                break;
            }
            // Reduzco 3 veces el precio
            case(2):{
                resultado = primerTotal * 0.33;
                break;
            }
            // Reduzco a la mitad el precio
            case(3):{
                resultado = primerTotal * 0.5;
                break;
            }
            // No lo reduzco
            default:
                resultado = primerTotal;

        }
        return resultado;
    }
}
