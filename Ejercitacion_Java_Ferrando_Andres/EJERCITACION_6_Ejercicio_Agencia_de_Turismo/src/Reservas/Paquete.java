package Reservas;

public class Paquete extends Reserva{

    private Aereo aereo;
    private Comida comida;
    private Hotel hotel;
    private Transfer transfer;

    public Paquete(double precio, int cantidad, Aereo a, Comida c, Hotel h, Transfer t) {
        super(precio, cantidad);
        this.aereo = a;
        this.comida = c;
        this.hotel = h;
        this.transfer = t;
    }

    public Aereo getAereo() {
        return aereo;
    }

    public void setAereo(Aereo aereo) {
        this.aereo = aereo;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "aereo=" + aereo.toString() +
                ", comida=" + comida.toString() +
                ", hotel=" + hotel.toString() +
                ", transfer=" + transfer.toString() +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
