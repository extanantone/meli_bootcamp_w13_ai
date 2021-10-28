package productos;

public abstract class Producto {

    private static int idIncremental = 0;
    private int idProducto;
    protected double precio;
    protected int tipoProducto;
    private String descripcion;
    private double desc;

    public Producto(double precio, int tipoProducto, String descripcion) {
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "productos.Producto{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }

    public abstract double calcularDescuento(double desc);
}
