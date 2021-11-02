package com.ejerciciosIntegradores.Integrador1.Dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculoList = new ArrayList<>();


    public void darDeAltaAuto(Moto moto) {

        if (vehiculoList.size()<= cantidadDeVehiculosPermitidos){
            vehiculoList.add(moto);
        }else{
            System.out.println("Cupo lleno");
        }

    }

    public void darDeAltaAuto(Auto auto) {

        if (vehiculoList.size()<= cantidadDeVehiculosPermitidos){
            vehiculoList.add(auto);
        }else{
            System.out.println("Cupo lleno");
        }

    }

    public void eliminarVehiculo(Vehiculo vehiculo){

        for (int i =0 ; i< vehiculoList.size(); i++){
            if (vehiculoList.get(i).getPatente().equals(vehiculo.getPatente())){
                vehiculoList.remove(i);
                break;
            }
        }
    }

    public void eliminarVehiculoConPatente(String patente){

        for (int i =0 ; i< vehiculoList.size(); i++){
            if (vehiculoList.get(i).getPatente().equals(patente)){
                vehiculoList.remove(i);
                break;
            }
        }
    }


    public Vehiculo ganador(){

        double ganador=0;
        double vganadorA=0;
        Vehiculo vehiculoGanador;

        if(vehiculoList.size()>0){
            vehiculoGanador=vehiculoList.get(0);
        } else {
            vehiculoGanador = null;
        }

        for (Vehiculo vganador:  vehiculoList){


            ganador = (vganador.getVelocidad()*(vganador.getAceleracion()/2))
                    / (vganador.getAnguloDeGiro()*(( vganador.getPeso()-vganador.getRuedas() )* 100));

            vganadorA = (vehiculoGanador.getVelocidad()*(vehiculoGanador.getAceleracion()/2))
                    / (vehiculoGanador.getAnguloDeGiro()*(( vehiculoGanador.getPeso()-vehiculoGanador.getRuedas() )* 100));


            if (ganador > vganadorA){
                vehiculoGanador = vganador;
            }


        }

        return vehiculoGanador;

    }

    public  void socorrer(Auto auto){
        System.out.println("Socorrioendo Auto con patente="+auto.getPatente());
    }

    public  void socorrer(Moto moto){
        System.out.println("Socorrioendo Moto con patente="+moto.getPatente());
    }



}
