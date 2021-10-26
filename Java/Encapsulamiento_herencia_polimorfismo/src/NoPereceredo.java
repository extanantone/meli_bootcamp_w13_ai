public class NoPereceredo extends Producto {
    private String tipo;

    public NoPereceredo(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {

        return "Productos{" +
                "nombre='" + super.getNombre() + '\'' +
                ", precio=" + super.getPrecio() + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';

    }
}
