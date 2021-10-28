package Ejercicio1AgenciaTurismo;

import java.util.Set;

public class ReservaTransporte implements Localizador{

    private final double COSTO_TRANSPORTE_DIA = 50;

    private Localizador localizador;

    private int dias;

    public ReservaTransporte(Localizador localizador, int dias) {
        this.localizador = localizador;
        this.dias = dias;
    }

    @Override
    public double getCosto() {
        return localizador.getCosto() + (Reservas.TRANSPORTE.getCostoDia()*this.dias);
    }

    @Override
    public Set<Reservas> getReservas() {

        Set <Reservas> reservas = localizador.getReservas();

        reservas.add(Reservas.TRANSPORTE);

        return reservas;
    }

}
