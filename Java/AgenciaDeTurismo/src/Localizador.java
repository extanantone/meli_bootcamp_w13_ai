import java.util.ArrayList;

public class Localizador {

    private Cliente cliente;
    private double total;
    ArrayList<Reserva> reservas;

    public Localizador(Cliente cliente, ArrayList<Reserva> reservas) {
        this.cliente = cliente;
        reservas.stream().forEach(reserva -> { this.total += reserva.valor(); });
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
}
