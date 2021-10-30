package Reservas;

public class Transfer extends Reserva{

    private String destino;

    public Transfer(double precio, int cantidad, String destino) {
        super(precio, cantidad);
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "precio=" + precio +
                ", cantidad=" + cantidad +
                ", destino='" + destino + '\'' +
                '}';
    }
}
