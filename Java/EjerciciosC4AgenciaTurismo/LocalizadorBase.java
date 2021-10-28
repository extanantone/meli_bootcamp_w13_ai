package Ejercicio1AgenciaTurismo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LocalizadorBase implements Localizador{

    private double costo;

    private Viajero viajero;

    private Set<Reservas> reservas;

    public LocalizadorBase(Viajero viajero) {
        this.costo = COSTO_BASE;
        this.reservas = new HashSet<>();
        this.viajero = viajero;
    }

    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public Set getReservas() {
        return this.reservas;
    }


}
