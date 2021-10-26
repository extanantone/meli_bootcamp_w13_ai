import java.util.StringJoiner;

public class NoPerecedero extends Producto
{
    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo)
    {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo()
    {
        return tipo;
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", NoPerecedero.class.getSimpleName() + "[", "]")
                .add("tipo='" + tipo + "'")
                .add("nombre='" + nombre + "'")
                .add("precio=" + precio)
                .toString();
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
}
