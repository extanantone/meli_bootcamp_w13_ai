package Dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        vehiculos = new ArrayList<>();
        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion,
                              double anguloDeGiro, String patente) {
        if (!existeCupo()) return;
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        vehiculos.add(auto);
    }

    public void darDeAltaMoto(double velocidad, double aceleracion,
                              double anguloDeGiro, String patente) {
        if (!existeCupo()) return;
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        vehiculos.add(moto);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst().ifPresent(vehiculoEncontrado -> vehiculos.remove(vehiculoEncontrado));
    }

    private boolean existeCupo() {
        return vehiculos.size() < cantidadVehiculosPermitidos;
    }

    public Vehiculo encontrarGanador() {
        return vehiculos.stream().max(Comparator.comparing(Vehiculo::formulaCarrera)).orElseThrow();
    }

    public void socorrerAuto(String patente) {
        vehiculos.stream()
                .filter(auto -> auto.getPatente().equals(patente))
                .findFirst().ifPresent(auto -> socorristaAuto.socorrer((Auto) auto));
    }

    public void socorrerMotos(String patente) {
        vehiculos.stream()
                .filter(moto -> moto.getPatente().equals(patente))
                .findFirst().ifPresent(moto -> socorristaMoto.socorrerMoto((Moto) moto));
    }
}
