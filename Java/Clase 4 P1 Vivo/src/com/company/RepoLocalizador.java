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
        if (localizador.getReservas().stream().anyMatch(r -> r.getTipoReserva().equals(TipoReserva.HOTEL)) &&
                localizador.getReservas().stream().anyMatch(r -> r.getTipoReserva().equals(TipoReserva.BOLETOS)) &&
                localizador.getReservas().stream().anyMatch(r -> r.getTipoReserva().equals(TipoReserva.COMIDA)) &&
                localizador.getReservas().stream().anyMatch(r -> r.getTipoReserva().equals(TipoReserva.TRANSPORTE))){
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

    public int cantidadLocalizadoresVendidos(){
        return localizadores.size();
    }

    public int cantidadReservasVendidas(){
        return (int) localizadores.stream().mapToInt(l -> l.getReservas().size()).count();
    }

    public void imprimirReservasPorTipo(){
        System.out.print("La cantidad de reservas de hotel fue de ");
        System.out.print(localizadores.stream().map(Localizador::getReservas).mapToLong(r -> r.stream().filter(re -> re.getTipoReserva().equals(TipoReserva.HOTEL)).count()).sum() + " reservas \n");
        System.out.print("La cantidad de reservas de boletos de viaje fue de ");
        System.out.print(localizadores.stream().map(Localizador::getReservas).mapToLong(r -> r.stream().filter(re -> re.getTipoReserva().equals(TipoReserva.BOLETOS)).count()).sum() + " reservas \n");
        System.out.print("La cantidad de reservas de comida fue de ");
        System.out.print(localizadores.stream().map(Localizador::getReservas).mapToLong(r -> r.stream().filter(re -> re.getTipoReserva().equals(TipoReserva.COMIDA)).count()).sum() + " reservas \n");
        System.out.print("La cantidad de reservas de transporte fue de ");
        System.out.print(localizadores.stream().map(Localizador::getReservas).mapToLong(r -> r.stream().filter(re -> re.getTipoReserva().equals(TipoReserva.TRANSPORTE)).count()).sum() + " reservas \n");
    }

    public double totalVentas(){
        return localizadores.stream().mapToDouble(Localizador::getTotal).sum();
    }

    public double promedioVentas(){
        return localizadores.stream().mapToDouble(Localizador::getTotal).average().orElse(-1);
    }
}

