public class Transporte implements Reserva{
    private double precio;
    private String nombre;
    private Reserva reserva;

    public Transporte(double precio, String nombre,Reserva reserva) {
        this.precio = precio;
        this.nombre = nombre;
        this.reserva=reserva;
    }
    @Override
    public double getPrecio() {
        return this.precio+reserva.getPrecio();
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getDetalle() {
        return reserva.getDetalle()+", El nombre del paquete de transporte es "+nombre;
    }
}
