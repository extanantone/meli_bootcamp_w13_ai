package com.company;

import java.util.ArrayList;
import java.util.List;

public class Carrera
{
    double distancia;
    double premioEnDolares;
    String nombre;
    int cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaVehiculos;
    Socorrista<Auto> socorristaAuto;
    Socorrista<Moto> socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        socorristaMoto = new Socorrista<>();
        socorristaAuto = new Socorrista<>();
        listaVehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaVehiculos.size() < cantidadDeVehiculosPermitidos)
            listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaVehiculos.size() < cantidadDeVehiculosPermitidos)
            listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        listaVehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        listaVehiculos.stream().filter(v -> v.patente.equals(unaPatente)).findFirst().ifPresent(vehiculoAEliminar -> listaVehiculos.remove(vehiculoAEliminar));
    }

    public void correr(){
        double numeroGanador = 0;
        Vehiculo ganador = null;
        for (Vehiculo vel: listaVehiculos) {
            double numeroActual = vel.formulaGanadora();
            if(ganador == null || numeroActual > numeroGanador){
                ganador = vel;
                numeroGanador = numeroActual;
            }
        }
        if (ganador != null)
            System.out.println("El ganador fue el vehiculo con patente " + ganador.patente + " con " + numeroGanador + " puntos ");
        else
            System.out.println("No hubo ganador por falta de competidores");
    }

    public void socorrerAuto(String patente){
        // Busco la patente y ademas me aseguro que tenga 4 ruedas para castearlo a auto
        listaVehiculos.stream().filter(v -> v.patente.equals(patente) && v.ruedas == 4).findFirst().ifPresent(v -> socorristaAuto.socorrer((Auto) v));
    }

    public void socorrerMoto(String patente){
        // Busco la patente y ademas me aseguro que tenga 2 ruedas para castearlo a moto
        listaVehiculos.stream().filter(v -> v.patente.equals(patente) && v.ruedas == 2).findFirst().ifPresent(v -> socorristaMoto.socorrer((Moto) v));
    }
}
