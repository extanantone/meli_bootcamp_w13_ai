package Reservas;

import Interfaces.Reservable;

import java.time.LocalDateTime;

public abstract class Reserva implements Reservable {
    private LocalDateTime diaReserva;
    protected double costoUnitario;

    public Reserva(LocalDateTime diaReserva, double costoUnitario) {
        this.diaReserva = diaReserva;
        this.costoUnitario = costoUnitario;
    }

    public Reserva(LocalDateTime diaReserva) {
        this.diaReserva = diaReserva;
    }

    @Override
    public String toString() {
        return "Reserva {" +
                "diaReserva=" + diaReserva +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
