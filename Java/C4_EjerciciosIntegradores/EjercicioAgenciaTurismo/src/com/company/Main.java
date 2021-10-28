package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public void prepararPrueba(){
        List<Localizador> repositorioCliente = new ArrayList<>();

        Localizador l = new Localizador();

        List<Reserva> listaReservas = new ArrayList<>();
        Reserva r = new ReservaHotel(1);
        listaReservas.add(r);

        l.setListaReserva(listaReservas);

    }

    public static void main(String[] args) {
        //Preparo parametros de prueba
        prepararPrueba();
    }
}
