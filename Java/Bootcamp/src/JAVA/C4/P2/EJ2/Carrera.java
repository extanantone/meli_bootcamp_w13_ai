package JAVA.C4.P2.EJ2;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private double precioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;


    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (cantidadDeVehiculosPermitidos < vehiculos.size()) {
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (cantidadDeVehiculosPermitidos < vehiculos.size()) {
            Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        this.vehiculos.remove(this.vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(unaPatente)));
    }

    public Vehiculo ganador(ArrayList<Vehiculo> vehiculosEnCarrera) {
        return vehiculosEnCarrera.stream().max(Comparator.comparing(Vehiculo::formulaGanador)).orElseThrow(NoSuchElementException::new);
    }

    public void socorrerAuto(String unaPatente){
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        Auto auto = (Auto) this.vehiculos.stream().filter(v -> v.getPatente().equals(unaPatente));
        socorristaAuto.socorrer(auto);
    }

    public void socorrerMoto(String unaPatente){
        SocorristaMoto socorristaMoto = new SocorristaMoto();
        Moto moto = (Moto) this.vehiculos.stream().filter(v -> v.getPatente().equals(unaPatente));
        socorristaMoto.socorrer(moto);
    }
}
