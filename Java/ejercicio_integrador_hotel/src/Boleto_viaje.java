public class Boleto_viaje implements Reserva{
    private double precio;
    private String destino;
    private String origen;
    private Reserva reserva;

    public Boleto_viaje(double precio, String destino, String origen,Reserva reserva) {
        this.precio = precio;
        this.destino = destino;
        this.origen = origen;
        this.reserva=reserva;
    }

    public double getPrecio() {
        return this.precio+reserva.getPrecio();
    }

    public void setPrecio(double precio) {
        this.precio=precio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String getDetalle() {
        return reserva.getDetalle()+", El boleto de viaje es de "+origen+" a "+destino;
    }
}
