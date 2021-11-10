package Reservas;

public class Comida extends Reserva {

    private String destino;

    public Comida(double precio, int cantidad, String destino) {
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
        return "Comida{" +
                "destino='" + destino + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}

