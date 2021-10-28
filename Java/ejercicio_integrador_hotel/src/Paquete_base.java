public class Paquete_base implements Reserva{
    private String nombre;
    private double precio_base;

    public Paquete_base(double precio_base, String nombre) {
        this.precio_base = precio_base;
        this.nombre=nombre;
    }

    public double getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(double precio_base) {
        this.precio_base = precio_base;
    }


    @Override
    public double getPrecio() {
        return precio_base;
    }

    @Override
    public String getDetalle() {
        return nombre;
    }

}
