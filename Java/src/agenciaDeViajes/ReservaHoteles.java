package agenciaDeViajes;

public class ReservaHoteles implements Reserva {
    private double costo;

    public ReservaHoteles(double costo) {
        this.costo = costo;
    }

    @Override
    public double costo() {
        return costo;
    }

    @Override
    public String tipoReserva() {
        return "ReservaHoteles";
    }

}
