package Productos;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String inNombre, double inPrecio, int inDiasPorCaducar) {
        super(inNombre, inPrecio);
        this.diasPorCaducar = inDiasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return this.diasPorCaducar;
    }

    public void setDiasPorCaducar(int inDiasPorCaducar) {
        this.diasPorCaducar = inDiasPorCaducar;
    }

    @Override
    public String toString() {
        return String.format("+ Nombre: %s\n+ Precio: %f\n+ Días por caducar: %d",
            this.nombre, this.precio,this.diasPorCaducar);
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = this.precio * cantidadDeProductos;
        if (this.diasPorCaducar == 1) return precioFinal/4;
        else if (this.diasPorCaducar == 2) return precioFinal/3;
        else if (this.diasPorCaducar == 3) return precioFinal/2;
        return precioFinal;
    }
}
