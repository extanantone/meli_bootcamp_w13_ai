import java.util.List;

public class Localizador {
    private Viajero cliente;
    private List<Reserva> reserva;

    public Localizador(Viajero cliente, List<Reserva> reserva) {
        this.cliente = cliente;
        this.reserva = reserva;
    }

    public Viajero getCliente() {
        return cliente;
    }

    public void setCliente(Viajero cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }


}
