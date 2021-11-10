package Reservas;

public class Hotel extends Reserva {

    private String destino;
    private String nombreHotel;

    public Hotel(double precio, int cantidad, String destino, String nombreHotel) {
        super(precio, cantidad);
        this.destino = destino;
        this.nombreHotel = nombreHotel;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "destino='" + destino + '\'' +
                ", nombreHotel='" + nombreHotel + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
