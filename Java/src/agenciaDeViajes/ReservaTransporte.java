package agenciaDeViajes;

public class ReservaTransporte implements Reserva {
    private double costo;
    public ReservaTransporte(double costo) {
        this.costo = costo;
    }

    @Override
    public double costo() {
        return costo;
    }

    @Override
    public String tipoReserva() {
        return "ReservaTransporte";
    }

}
