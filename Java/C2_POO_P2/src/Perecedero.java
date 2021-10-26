import java.util.HashMap;
import java.util.StringJoiner;

public class Perecedero extends Producto
{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaudar)
    {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaudar;
    }

    public int getDiasPorCaducar()
    {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar)
    {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidad)
    {
        double precioFinal;
        precioFinal = super.calcular(cantidad);
        HashMap<Integer, Integer> relacionPrecio = new HashMap();
        relacionPrecio.put(1, 4);
        relacionPrecio.put(2, 3);
        relacionPrecio.put(3, 2);
        precioFinal = precioFinal/relacionPrecio.get(diasPorCaducar);
        return (precioFinal);
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", Perecedero.class.getSimpleName() + "[", "]")
                .add("diasPorCaudar=" + diasPorCaducar)
                .add("nombre='" + nombre + "'")
                .add("precio=" + precio)
                .toString();
    }
}
