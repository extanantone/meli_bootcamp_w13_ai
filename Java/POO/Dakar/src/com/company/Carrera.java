package com.company;

import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private double nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, double nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAuto = new SocorristaAuto(1, 1,1, "Socorrista");
        this.socorristaMoto = new SocorristaMoto(1, 1, 1, "Socorrista");
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public double getNombre() {
        return nombre;
    }

    public void setNombre(double nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        for (Vehiculo vehiculo : this.listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                listaDeVehiculos.remove(vehiculo);
            }
        }
    }

    public void encontrarGanador() {
        double ganadorResultado = 0;
        Vehiculo ganadorVehiculo = null;

        for(Vehiculo vehiculo : this.listaDeVehiculos){
            double result = vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2)/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (result > ganadorResultado){
                ganadorVehiculo = vehiculo;
                ganadorResultado = result;
            }
        }
        System.out.println("El ganador de la carrera " + nombre  + "es el vehículo con patente: " + ganadorVehiculo.getPatente());
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo vehiculo : this.listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) vehiculo);
            }
        }
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo vehiculo : this.listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto)vehiculo);
            }
        }
    }
}
