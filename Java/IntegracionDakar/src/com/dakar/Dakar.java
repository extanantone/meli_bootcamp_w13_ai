package com.dakar;

public class Dakar {
    public static void main(String[] args) {
        Auto auto1 = new Auto(300.0, 100.0, 75.0, "AJK 197");
        Carrera dakar = new Carrera(174.5, 1000.0, "Dakar", 5);

        System.out.println("");

        dakar.eliminarVehiculo(auto1);
        dakar.darDeAltaAuto(300.0, 100.0, 75.0, "AJK 197");
        dakar.darDeAltaAuto(370.0, 99.0, 90.0, "ABF 123");
        dakar.darDeAltaAuto(270.0, 84.0, 90.0, "PPP 223");

        System.out.println("");

        dakar.darDeAltaMoto(150.0, 59.7, 34.2, "MOT 069");
        dakar.darDeAltaMoto(350.0, 7.3, 150.0, "ONE 234");
        dakar.eliminarVehiculo("MOT 069");
        dakar.darDeAltaMoto(350.0, 7.3, 150.0, "ONE 234");

        System.out.println("");

        dakar.socorrerAuto("AJK 197");
        dakar.socorrerAuto("BBB 267");
        dakar.socorrerMoto("MOT 069");
        dakar.socorrerMoto("ONE 234");
    }
}
