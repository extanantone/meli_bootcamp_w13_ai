package com.dakar;

import java.util.*;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private Set<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera(Double distancia,
                   Double premioEnDolares,
                   String nombre,
                   Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new HashSet<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }


    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {

        if (!hayCupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta un auto ");
            return;
        }

        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);

        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(auto.getPatente())) {
                System.out.println("El Auto ya estaba inscripto");
                return;
            }
        }


        boolean contains = listaDeVehiculos.contains(auto);
        if (contains) {
            System.out.println("Ya inscrito!");
            return;
        }


        boolean agregadoCorrectamente = listaDeVehiculos.add(auto);
        if (!agregadoCorrectamente) {
            System.out.println("Ya inscrito!");
            return;
        }

        System.out.println("Auto Agregado!");

    }

    private Boolean hayCupoDisponible() {
        return cantidadDeVehiculosPermitidos > listaDeVehiculos.size();
    }


    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!hayCupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta una moto");
            return;
        }

        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);

        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(moto.getPatente())) {
                System.out.println("Moto ya inscrita!");
                return;
            }
        }

        listaDeVehiculos.add(moto);
        System.out.println("Moto Agregada!");
    }

    public void eliminarVehiculo(String patente) {

        Vehiculo vehiculosAEliminar = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                vehiculosAEliminar = vehiculo;
            }
        }

        if (vehiculosAEliminar != null) {
            eliminarVehiculo(vehiculosAEliminar);
        } else {
            System.out.println("El vehículo solicitado para eliminar no se encuentra inscrito.");
        }
    }

    public void eliminarVehiculo(Vehiculo unVehiculo) {
        if (listaDeVehiculos.remove(unVehiculo)) {
            System.out.println("Se eliminó correctamente el vehículo: " + unVehiculo);
        } else {
            System.out.println("El vehículo: " + unVehiculo + " no se encuentra inscrito.");
        }
    }

    public void socorrerAuto(String patente) {
        Auto autoASocorrer = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Auto) {
                autoASocorrer = (Auto) vehiculo;
            }
        }

        if (autoASocorrer != null) {
            socorristaAuto.socorrer(autoASocorrer);
        } else {
            System.out.println("No existe auto con la patente especificada para ser socorrido.");
        }
    }

    public void socorrerMoto(String patente) {
        Moto motoASocorrer = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Moto) {
                motoASocorrer = (Moto) vehiculo;
            }
        }

        if (motoASocorrer != null) {
            socorristaMoto.socorrer(motoASocorrer);
        } else {
            System.out.println("No existe moto con la patente especificada para ser socorrido.");
        }
    }

}
