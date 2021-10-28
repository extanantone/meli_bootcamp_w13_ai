package Reservas;

import Interfaces.Descontable;

import java.time.LocalDateTime;

public class ReservaBoletoViaje extends Reserva implements Descontable {
    private String origen;
    private String destino;
    private int cantidadBoletos;

    public ReservaBoletoViaje(LocalDateTime diaReserva, double costoUnitario,
                              String origen, String destino, int cantidadBoletos) {
        super(diaReserva, costoUnitario);
        this.origen = origen;
        this.destino = destino;
        this.cantidadBoletos = cantidadBoletos;
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
