import java.util.ArrayList;
import java.util.List;

public class Carrera {
    Double distancia, premioEnDolares;
    String nombre;
    Integer cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaDeVehiculos;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<Vehiculo>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Vehiculo añadido");
        }else {
            System.out.println("Vehiculo no añadido");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
        }else {
            System.out.println("Vehiculo no añadido");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
        System.out.println("Se elimino el vehiculo");
    }

    public void elminarVehiculoConPatente(String patente){
        listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public void ganadorCarrera(){
        System.out.println(listaDeVehiculos.stream().mapToDouble(v-> v.getValorFormula()).max());
    }
}
