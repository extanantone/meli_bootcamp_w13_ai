package Ejercicio1AgenciaTurismo;

import java.util.Set;

public class ReservaHotel implements Localizador{

    private Localizador localizador;

    private int dias;

    public ReservaHotel(Localizador localizador, int dias) {
        this.localizador = localizador;
        this.dias=dias;
    }

    @Override
    public double getCosto() {
        return localizador.getCosto() + (Reservas.HOTEL.getCostoDia() * this.dias);
    }

    @Override
    public Set<Reservas> getReservas() {

        Set <Reservas> reservas = localizador.getReservas();

        reservas.add(Reservas.HOTEL);

        return reservas;
    }
}
