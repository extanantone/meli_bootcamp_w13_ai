package Java_IV_b.Dakar;

import java.util.List;

public class Carrera {
    double distancia;
    int premioEnDolares;
    String nombre;
    int cantidadDeVehiculos;
    List<Vehiculo> listaDeVehiculos;

    public void darDeAltaAuto(int velocidad,double aceleracion,double anguloDeGiro,String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculos){
            listaDeVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
        }
    }

    public void darDeAltaMoto(int velocidad,double aceleracion,double anguloDeGiro,String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculos){
            listaDeVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
        }
    }

}
