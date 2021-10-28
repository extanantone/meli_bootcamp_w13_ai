public class Reserva_hotel implements Reserva{
    private double precio;
    private String hotel;
    private Reserva reserva;

    public Reserva_hotel(double precio, String hotel, Reserva reserva) {
        this.precio = precio;
        this.hotel = hotel;
        this.reserva=reserva;
    }

    @Override
    public double getPrecio() {
        return this.precio+reserva.getPrecio();
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    @Override
    public String getDetalle() {
        return reserva.getDetalle()+", El nombre del hotel es "+hotel;
    }
}
