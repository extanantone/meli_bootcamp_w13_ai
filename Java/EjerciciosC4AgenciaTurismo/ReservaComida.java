package Ejercicio1AgenciaTurismo;

import java.util.Set;

public class ReservaComida implements Localizador{

    private Localizador localizador;

    private int dias;

    public ReservaComida(Localizador localizador, int dias) {
        this.localizador = localizador;
        this.dias=dias;

    }

    @Override
    public double getCosto() {
        return this.localizador.getCosto() + (Reservas.COMIDA.getCostoDia()*this.dias);
    }


    @Override
    public Set<Reservas> getReservas() {

        Set <Reservas> reservas = localizador.getReservas();

        reservas.add(Reservas.COMIDA);

        return reservas;
    }

}
