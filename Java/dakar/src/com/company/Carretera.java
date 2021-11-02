package com.company;

import java.util.ArrayList;

public class Carretera {
    private double distancia;
    private double PremioEnDolares;
    private String nombre;
    private int CantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private SocorristaAuto socorroAuto  = new SocorristaAuto;
    private SocorristaMoto socorroMoto  = new SocorristaMoto;


    public void darDeAltaAuto(double velocidad, double acceleracion, double anguloDeGiro, String  patente){

    }

    public void darDeAltaMoto(double velocidad, double acceleracion, double anguloDeGiro, String  patente){

    }

    public void eliminarVeciculo(Vehiculo v){

    }

    public void eliminarConPatente(String p){

    }

    public Vehiculo ganador(){
        Vehiculo primerLugar = listaVehiculos.get(0);

        for ( Vehiculo x : listaVehiculos) {
            if ( formulaGanador(x) > formulaGanador(primerLugar) ){
                primerLugar = x;
            }
        }
        return primerLugar;
    }


    public Vehiculo getAutoPatente(String p){
        Vehiculo primerLugar = listaVehiculos.get(0);

        for ( Vehiculo x : listaVehiculos) {
            if ( p.equals(x.getPatente())) {
                 return x;
            }
        }

        return primerLugar;
    }



    private  double formulaGanador( Vehiculo x){
        return (x.getVelocidad()* x.getAceleracion() / 2) / (x.getAnguloDeGiro()* ( x.getPeso() - x.getRuedas() * 100));
    }


    private void socorrerAuto(String patente){
        Vehiculo x = getAutoPatente(patente);

        if ( x.getRuedas() == 2){
            socorroMoto.Socorrer((Moto) x);
        }else {
            socorroAuto.Socorrer((Auto) x);
        }

    }



}
