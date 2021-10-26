package Clase2_Práctico2;

class Pereceredo extends Producto {
    private int diasPorCaducar;

    public Pereceredo(String nombre, double precio, int diasPorCaducar) {
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
        return "Productos{" +
                "nombre='" + super.getNombre() + '\'' +
                ", precio=" + super.getPrecio() + '\'' +
                ", diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidad) {
        double valor = super.calcular(cantidad);
        if(this.diasPorCaducar == 1) return valor/4;
        else if(this.diasPorCaducar == 2) return valor/3;
        else if(this.diasPorCaducar == 3) return valor/2;
        else return valor;
    }
}