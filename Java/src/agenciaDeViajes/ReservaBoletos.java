package agenciaDeViajes;

public class ReservaBoletos implements Reserva {
    private double costo;

    public ReservaBoletos(double costo) {
        this.costo = costo;
    }

    @Override
    public double costo() {
        return costo;
    }

    @Override
    public String tipoReserva() {
        return "ReservaBoletos";
    }
}
