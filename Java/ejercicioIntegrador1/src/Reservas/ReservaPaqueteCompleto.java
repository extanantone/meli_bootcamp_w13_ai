package Reservas;

import java.time.LocalDateTime;

public class ReservaPaqueteCompleto extends Reserva {
    private ReservaBoletoViaje boletoViaje;
    private ReservaComida reservaComida;
    private ReservaHotel reservaHotel;
    private ReservaTransporte reservaTransporte;

    public ReservaPaqueteCompleto(LocalDateTime diaReserva, ReservaBoletoViaje boletoViaje,
                                  ReservaComida reservaComida, ReservaHotel reservaHotel,
                                  ReservaTransporte reservaTransporte) {
        super(diaReserva);
        this.boletoViaje = boletoViaje;
        this.reservaComida = reservaComida;
        this.reservaHotel = reservaHotel;
        this.reservaTransporte = reservaTransporte;
        this.costoUnitario = calcularCosto();
    }

    @Override
    public double calcularCosto() {
        return boletoViaje.calcularCosto() + reservaComida.calcularCosto() +
                reservaHotel.calcularCosto() + reservaTransporte.calcularCosto();
    }
}
