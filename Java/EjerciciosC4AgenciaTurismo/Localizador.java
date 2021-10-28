package Ejercicio1AgenciaTurismo;

import java.util.Set;

public interface Localizador {

    double COSTO_BASE = 50;

    double getCosto();

    Set<Reservas> getReservas();

}
