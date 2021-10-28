package Ejercicio1AgenciaTurismo;

import java.util.Set;

public class ReservaBoletos implements Localizador{

    private Localizador localizador;

    private int dias;

    public ReservaBoletos(Localizador localizador) {
        this.dias = dias;
        this.localizador = localizador;
    }

    @Override
    public double getCosto() {
        return localizador.getCosto() + Reservas.BOLETOS.getCostoDia()*this.dias;
    }

    @Override
    public Set<Reservas> getReservas() {

        Set <Reservas> reservas = localizador.getReservas();

        reservas.add(Reservas.BOLETOS);

        return reservas;
    }
}
