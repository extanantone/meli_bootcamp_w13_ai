package dakar;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private List<Socorrista> listaDeSocorristas;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.listaDeSocorristas = new ArrayList<>();
    }

    public Double getDistancia() {
        return distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public List<Socorrista> getListaDeSocorristas() {
        return listaDeSocorristas;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void setListaDeSocorristas(List<Socorrista> listaDeSocorristas) {
        this.listaDeSocorristas = listaDeSocorristas;
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        this.listaDeVehiculos.add(new Auto(patente,velocidad,aceleracion,anguloDeGiro));
    }
    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        this.listaDeVehiculos.add(new Moto(patente,velocidad,aceleracion,anguloDeGiro));
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        this.listaDeVehiculos.remove(vehiculo);
    }
    public void eliminarVehiculo(String patente){
        this.listaDeVehiculos.removeIf(x -> x.getPatente().equals(patente));
    }
    public Vehiculo definirGanador(){
        Map<Double, Vehiculo> diccionarioResultados = new HashMap<>();
        this.listaDeVehiculos.forEach(x -> diccionarioResultados.put((x.getVelocidad() * (x.getAceleracion()/2))/(x.getAnguloDeGiro() * ((x.getPeso() - x.getRuedas()) * 100)), x));
        return diccionarioResultados.get(Collections.max(diccionarioResultados.keySet()));
    }
}
