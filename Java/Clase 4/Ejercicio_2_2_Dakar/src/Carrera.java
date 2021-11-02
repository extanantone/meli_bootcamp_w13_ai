import java.util.List;
import java.util.stream.Collectors;

public class Carrera {

    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantidadVehiculos;
    private List<Vehiculo> vehiculos;


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
}
