public class Perecederos extends Producto{
    private int diasPorCaducar;

    public Perecederos(String nombre,double precio,int diasPorCaducar){
        super(nombre,precio);
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
        return "Perecedero: " + '\n' +
                " - dias por caducar=" + diasPorCaducar + '\n' +
                " - nombre=" + nombre + '\n' +
                " - precio=" + precio;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precio;
        precio = super.calcular(cantidadDeProductos);

        switch (this.diasPorCaducar){
            case 1:
                precio = precio/4;
                break;
            case 2:
                precio = precio/3;
                break;
            case 3:
                precio = precio/2;
                break;
        }
        return precio;
    }
}