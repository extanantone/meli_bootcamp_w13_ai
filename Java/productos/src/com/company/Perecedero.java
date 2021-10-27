package com.company;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
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
    public double calcular(int cantidadDeProductos){
        double precioProvisorio = super.calcular(cantidadDeProductos);

        if (diasPorCaducar > 4) return precioProvisorio;
        return precioProvisorio / (5 - diasPorCaducar;

    }
}

// Esta clase debe heredar de Producto y sobreescribir el método calcular()
// el cual tiene que hacer lo mismo que la clase Producto (multiplicar el precio por la cantidad de productos)
// y adicionalmente, reducir el precio según los diasPorCaducar:

//Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
//Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
//Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.
//