package Reservas;

import java.time.LocalDateTime;

public class ReservaComida extends Reserva {
    private String restaurante;

    public ReservaComida(LocalDateTime diaReserva, double costoUnitario, String restaurante) {
        super(diaReserva, costoUnitario);
        this.restaurante = restaurante;
    }

    @Override
    public double calcularCosto() {
        return costoUnitario;
    }
}
