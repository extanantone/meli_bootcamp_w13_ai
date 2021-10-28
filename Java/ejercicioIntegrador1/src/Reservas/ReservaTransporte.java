package Reservas;

import Reservas.Reserva;

import java.time.LocalDateTime;

public class ReservaTransporte extends Reserva {
    private String origen;
    private String destino;

    public ReservaTransporte(LocalDateTime diaReserva, double costoUnitario, String origen, String destino) {
        super(diaReserva, costoUnitario);
        this.origen = origen;
        this.destino = destino;
    }

    @Override
    public double calcularCosto() {
        return costoUnitario;
    }
}
