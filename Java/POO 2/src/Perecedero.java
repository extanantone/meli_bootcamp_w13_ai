public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(){

    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        this.nombre = nombre;
        this.precio = precio;
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public double calcular(int cantidadDeProductos){
        int divisor = 1;
        switch (this.diasPorCaducar){
            case 1: divisor = 4;
            break;
            case 2: divisor = 3;
            break;
            case 3: divisor = 2;
            break;
            default:
                divisor = 1;
                break;
        }
        return (this.precio / divisor) * cantidadDeProductos;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Precio: "+ this.precio +" Dias por caducar: "+this.diasPorCaducar;
    }
}
