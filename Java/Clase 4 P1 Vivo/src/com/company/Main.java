package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RepoLocalizador repoLocalizador = new RepoLocalizador();
        RepoCliente repoCliente = new RepoCliente();
        repoCliente.addCliente(new Cliente("Vale", 29123019L));
        repoCliente.addCliente(new Cliente("Juan", 29381930L));
        repoCliente.addCliente(new Cliente("Marco",31948201L));

        List<Reserva> reservas1 = new ArrayList<>();
        reservas1.add(new Reserva(1000.d, TipoReserva.HOTEL));
        reservas1.add(new Reserva(3000.d, TipoReserva.BOLETOS));
        reservas1.add(new Reserva(750.d, TipoReserva.COMIDA));
        reservas1.add(new Reserva(400.d, TipoReserva.TRANSPORTE));

        List<Reserva> reservas2 = new ArrayList<>();
        reservas2.add(new Reserva(1000.d, TipoReserva.HOTEL));
        reservas2.add(new Reserva(1200.d, TipoReserva.HOTEL));
        reservas2.add(new Reserva(2300.d, TipoReserva.BOLETOS));
        reservas2.add(new Reserva(4000.d, TipoReserva.BOLETOS));

        List<Reserva> reservas3 = new ArrayList<>();
        reservas3.add(new Reserva(700.d, TipoReserva.TRANSPORTE));

        List<Reserva> reservas4 = new ArrayList<>();
        reservas4.add(new Reserva(1400.d, TipoReserva.HOTEL));
        reservas4.add(new Reserva(2000.d, TipoReserva.BOLETOS));
        reservas4.add(new Reserva(400.d, TipoReserva.COMIDA));
        reservas4.add(new Reserva(800.d, TipoReserva.TRANSPORTE));

        repoLocalizador.addLocalizador(new Localizador(reservas1, repoCliente.getCliente(0)));
        repoLocalizador.addLocalizador(new Localizador(reservas2, repoCliente.getCliente(0)));
        repoLocalizador.addLocalizador(new Localizador(reservas3, repoCliente.getCliente(0)));
        repoLocalizador.addLocalizador(new Localizador(reservas4, repoCliente.getCliente(0)));

        System.out.println("Localizadores vendidos : " + repoLocalizador.cantidadLocalizadoresVendidos());
        System.out.println("Reservas vendidas : " + repoLocalizador.cantidadReservasVendidas());
        repoLocalizador.imprimirReservasPorTipo();
        System.out.println("Total de ventas : $" + repoLocalizador.totalVentas());
        System.out.println("Promedio de ventas : $" + repoLocalizador.promedioVentas());

    }
}
