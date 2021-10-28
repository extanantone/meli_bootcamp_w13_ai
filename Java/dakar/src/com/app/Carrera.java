package com.app;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private int premioDolares;
    private String nombre;
    private int cantidadPermitidaVehiculos;
    private List<Vehiculo> vehiculos;
    private List<Auto> autos;
    private List<Moto> motos;
    private Socorrista<Auto> socorristaAuto;
    private Socorrista<Moto> socorristaMoto;

    public Carrera(double distancia,int premioDolares, String nombre, int cantidadPermitidaVehiculos){
        this.distancia = distancia;
        this.premioDolares=premioDolares;
        this.nombre = nombre;
        this.cantidadPermitidaVehiculos = cantidadPermitidaVehiculos;
        vehiculos = new ArrayList<>();
        autos = new ArrayList<>();
        motos=new ArrayList<>();
        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    public int getCantidadPermitidaVehiculos() {
        return cantidadPermitidaVehiculos;
    }

    public double getDistancia() {
        return distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPremioDolares() {
        return premioDolares;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void darDeAltaCarro(double velocidad,double aceleracion,double angulo,String patente){
        if(vehiculos.size()<cantidadPermitidaVehiculos) 
                vehiculos.add(new Auto(velocidad, aceleracion, angulo, patente));
    }

    public void darDeAltaMoto(double velocidad,double aceleracion,double angulo,String patente){
        if(vehiculos.size()<cantidadPermitidaVehiculos)
            vehiculos.add(new Moto(velocidad, aceleracion, angulo, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        Vehiculo v = getVehiculo(patente);
        if(v!=null) vehiculos.remove(v);

    }

    private Vehiculo getVehiculo(String patente){
        return vehiculos.stream().filter(v->v.getPatente().equals(patente))
                .findFirst().orElse(null);
    }

    public Vehiculo winner(){
        if(vehiculos.size()==0)return null;
        double d = Double.MIN_VALUE;
        Vehiculo v = null;
        for(Vehiculo vehiculo:vehiculos){
            double d1 = vehiculo.evaluate();
            if(d1<d){
                v = vehiculo;
                d = d1;
            }
        }
        return v;

    }

    public void socorrerAuto(String patente){
        for(Vehiculo a:vehiculos){
            if(a.getPatente().equals(patente) && a instanceof Auto) 
                socorristaAuto.socorrer((Auto)a);
        }
    }

    public void socorrerMoto(String patente){
        for(Vehiculo a:vehiculos){
            if(a.getPatente().equals(patente) && a instanceof Moto) 
                socorristaMoto.socorrer((Moto)a);
        }
    }
}
