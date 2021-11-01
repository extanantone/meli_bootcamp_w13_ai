import vehiculos.Auto;
import vehiculos.Moto;
import vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos, ArrayList<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = vehiculos;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion,double AnguloDeGiro,String patente){

        final double PESO = 1000;
        final int RUEDAS = 4;

        vehiculos.add(new Auto(velocidad, aceleracion, AnguloDeGiro, patente, PESO, RUEDAS));

    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro,String patente){

        final double PESO = 300;
        final int RUEDAS = 2;

        vehiculos.add(new Moto(velocidad, aceleracion, AnguloDeGiro, patente, PESO, RUEDAS));

    }

    public void eliminarVehiculo(Vehiculo vehiculo){

        vehiculos.remove(vehiculo);

    }

    public void eliminarVehiculoConPatente(String patente){

        vehiculos.stream().filter( v -> v.getPatente() == patente);

        List<Vehiculo> listaVehiculosAuxiliar = new ArrayList<>();
        vehiculos.stream()
                .filter(item -> item.getPatente() == patente)
                .forEach(item -> {
                    listaVehiculosAuxiliar.add(item);
                });
        vehiculos.removeAll(listaVehiculosAuxiliar);

    }

    public Vehiculo obtenerVehiculoGanador(){

        Vehiculo vehiculoGanador = null;

        for (int i=0; i < vehiculos.size(); i++ ) {
            if(i == 0)
                vehiculoGanador = vehiculos.get(i);
            if(i != 0 && vehiculos.get(i).calcularParametros() > vehiculoGanador.calcularParametros())
                vehiculoGanador = vehiculos.get(i);
        }

        return vehiculoGanador;

    }



    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }
}

