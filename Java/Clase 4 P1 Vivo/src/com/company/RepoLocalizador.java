package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class RepoLocalizador {
    List<Localizador> localizadores;

    public RepoLocalizador(){
        localizadores = new ArrayList<>();
    }

    public void addLocalizador(Localizador localizador){
        List<Localizador> locPrevios = localizadores.stream().filter(l -> l.getCliente().getDni().equals(localizador.getCliente().getDni())).collect(Collectors.toList());
        double porcDescuento = 0;
        // Descuento por tener mas de dos localizadores comprados anteriormente
        if(locPrevios.size() >= 2){
            porcDescuento += 5;
            System.out.println("Se aplicó un descuento del 5% por tener dos o más localizadores comprados anteriormente");
        }
        // Descuento por tener dos reservas de hotel o dos reservas de boletos
        if (localizador.getReservas().stream().filter(r -> r.getTipoReserva().equals(TipoReserva.HOTEL)).count() == 2 ||
                localizador.getReservas().stream().filter(r -> r.getTipoReserva().equals(TipoReserva.BOLETOS)).count() == 2){
            porcDescuento += 5;
            System.out.println("Se aplicó un descuento del 5% por tener dos reservas de hotel y dos reservas de boleto");
        }
        // Descuento por tener una reserva de cada tipo
        if (localizador.getReservas().stream().filter(r -> r.getTipoReserva().equals(TipoReserva.HOTEL)).count() > 0 &&
                localizador.getReservas().stream().filter(r -> r.getTipoReserva().equals(TipoReserva.BOLETOS)).count() > 0 &&
                localizador.getReservas().stream().filter(r -> r.getTipoReserva().equals(TipoReserva.COMIDA)).count() > 0 &&
                localizador.getReservas().stream().filter(r -> r.getTipoReserva().equals(TipoReserva.TRANSPORTE)).count() > 0){
            porcDescuento += 10;
            System.out.println("Se aplicó un descuento del 10% por tener un paquete completo");
        }

        if(porcDescuento != 0) {
            System.out.print("Debia pagar $" + localizador.getTotal() );
            double finalPorcDescuento = porcDescuento;
            localizador.setReservas(localizador.getReservas().stream().map(r -> new Reserva(r.getPrecio() * (1 - finalPorcDescuento /100.d), r.getTipoReserva())).collect(Collectors.toList()));
            System.out.print(" y termino pagando con los descuentos $" + localizador.getTotal() + "\n");
        }else
            System.out.println("El paquete sale $" + localizador.getTotal());
        System.out.println("-----------------");
        localizadores.add(localizador);
    }

    public void removeLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }
}
