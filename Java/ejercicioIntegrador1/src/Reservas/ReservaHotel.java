package Reservas;

import Interfaces.Descontable;

import java.time.LocalDateTime;

public class ReservaHotel extends Reserva implements Descontable {
    private String nombreHotel;
    private int numeroHabitacion;

    public ReservaHotel(LocalDateTime diaReserva, double costoUnitario,
                        String nombreHotel, int numeroHabitacion) {
        super(diaReserva, costoUnitario);
        this.nombreHotel = nombreHotel;
        this.numeroHabitacion = numeroHabitacion;
    }

    @Override
    public double calcularCosto() {
        return costoUnitario;
    }

    @Override
    public void aplicarDescuento() {
        costoUnitario = costoUnitario - (costoUnitario * 0.05);
    }
}
