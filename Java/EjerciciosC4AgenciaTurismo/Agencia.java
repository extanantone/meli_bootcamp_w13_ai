package Ejercicio1AgenciaTurismo;

import java.util.Set;

public class Agencia {

    public static void main(String[] args) {

        Viajero v = new Viajero("1010","Juan");

        Localizador localizador = new ReservaBoletos(new LocalizadorBase(v));

        Set<Reservas> reservas = localizador.getReservas();

        for (Reservas reserva: reservas) {
            System.out.println("reserva.name() = " + reserva.name());
        }


    }


}
