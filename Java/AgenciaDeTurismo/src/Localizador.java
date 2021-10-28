import java.util.List;

public class Localizador {
    List<Reserva> reservas;
    Cliente cliente;
    double total;
    public Localizador(List<Reserva> inReservas, Cliente inSujeto, double inTotal) {
        this.reservas = inReservas;
        this.cliente = inSujeto;
        this.total = inTotal;
        this.cliente.addLocalizador(this);
    }

}
