package C4.ejercicioIntegradoresP2.dakar;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Carrera {

    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantidadVehiculos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera(double distancia, double premioDolares, String nombre, int cantidadVehiculos, List<Vehiculo> vehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculos = cantidadVehiculos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darAltaAuto(int velocidad, int aceleracion, double anguloGiro, String patente){
        if (cupo()){
            vehiculos.add(new Auto(velocidad,aceleracion,anguloGiro,patente));
        }
    }

    public void darAltaMoto(int velocidad, int aceleracion, double anguloGiro, String patente){
        if (cupo()){
            vehiculos.add(new Moto(velocidad,aceleracion,anguloGiro,patente));
        }
    }

    public boolean cupo(){
        return vehiculos.size() < cantidadVehiculos;
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        List<Vehiculo> vehPatente = vehiculos.stream().filter(vehiculo -> vehiculo.getPatente() == patente).collect(Collectors.toList());
    }

    public OptionalDouble obtenerGanador(){
        return vehiculos.stream().mapToDouble(x -> (x.getVelocidad() * (1/2)*x.getAceleracion())/( x.getAnguloDeGiro() * (x.getPeso()-x.getRuedas() * 100))).max();
    }

    public void socorrerAuto(String patente){

    }

    public void socorrerMoto(String patente){

    }
}
