package agenciaDeViajes;

public class ReservaComida implements Reserva {
    private double costo;

    public ReservaComida(double costo) {
        this.costo = costo;
    }

    @Override
    public double costo() {
        return costo;
    }

    @Override
    public String tipoReserva() {
        return "ReservaComida";
    }
}
