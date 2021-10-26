package herencia;

public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
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
        return "herencia.Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double result;
        if(this.diasPorCaducar==1){
            result= (cantidadDeProductos*(this.getPrecio()/4));
        }else if(this.diasPorCaducar==1){
            result= (cantidadDeProductos*(this.getPrecio()/3));
        }else {
            result= (cantidadDeProductos*(this.getPrecio()/2));
        }
        return result;
    }
}
