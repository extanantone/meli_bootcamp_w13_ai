package com.ejerciciosIntegradores.Integrador1.modelAgenciaTurismo;

import com.ejerciciosIntegradores.Integrador1.Interfaces.IReserva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Viajero viajero = new Viajero("Danuit",1067853552);
        Repositorio repositorio = new Repositorio();
        IReserva paquete1 = new BoletoViaje(1200,"Argentina","Colombia"
                            ,new Comida(100
                            , new Transporte(120
                            ,new ReservaHotel(1500,"Hilton"
                            ,new ReservaHotel(1500,"Paradice"
                            ,new PaqueteBase(100,"Completo"))))));
        IReserva paquete2 = new BoletoViaje(1200,"Argentina","Colombia"
                ,new Comida(100
                , new Transporte(120
                ,new ReservaHotel(1500,"Hilton"

                ,new PaqueteBase(100,"Completo")))));
        IReserva paquete3 = new BoletoViaje(1200,"Argentina","Colombia"
                ,new Comida(100
                , new Transporte(120
                ,new PaqueteBase(100,"Completo"))));

        Localizador localizador1 = new Localizador(viajero,paquete1);
        Localizador localizador2 = new Localizador(viajero,paquete2);
        Localizador localizador3 = new Localizador(viajero,paquete3);

        localizador1.descuentosCompra(repositorio);
        repositorio.setLocalizadors(localizador1);

        localizador2.descuentosCompra(repositorio);
        repositorio.setLocalizadors(localizador2);

        localizador3.descuentosCompra(repositorio);
        repositorio.setLocalizadors(localizador3);









    }
}
