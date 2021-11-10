package Darkar;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera
{
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private Integer cantidadVehiculosPermitidos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Carrera{");
        sb.append("distancia=").append(distancia);
        sb.append(", premioEnDolares=").append(premioEnDolares);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", cantidadVehiculosPermitidos=").append(cantidadVehiculosPermitidos);
        sb.append(", vehiculosList=").append(vehiculosList);
        sb.append('}');
        return sb.toString();
    }

    private List<Vehiculo> vehiculosList;

    public Carrera(double distancia, double premioEnDolares, String nombre, Integer cantidadVehiculosPermitidos)
    {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculosList = new LinkedList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double angDeGiro, String patente)
    {
        if (vehiculosList.size() > cantidadVehiculosPermitidos)
            return;

        Vehiculo vehiculo = vehiculosList.stream().filter((x) -> x.getPatente().equals(patente)).findFirst().orElse(null);
        if (vehiculo != null)
            return;

        vehiculo = new Auto(velocidad, aceleracion, angDeGiro, patente);
        System.out.println("Agregando");
        System.out.println(vehiculo);
        vehiculosList.add(vehiculo);
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double angDeGiro, String patente)
    {
        if (vehiculosList.size() > cantidadVehiculosPermitidos)
            return;

        Vehiculo vehiculo = vehiculosList.stream().filter((x) -> x.getPatente().equals(patente)).findFirst().orElse(null);
        if (vehiculo != null)
            return;

        vehiculo = new Moto(velocidad, aceleracion, angDeGiro, patente);
        System.out.println("Agregando");
        System.out.println(vehiculo);
        vehiculosList.add(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo)
    {
        if (vehiculosList.contains(vehiculo))
        {
            System.out.println("Eliminando");
            System.out.println(vehiculo);
            vehiculosList.remove(vehiculo);
        }
        else
            System.out.println("Vehiculo no encontrado");
    }


    public void eliminarVehiculoConPatente(String unaPatente)
    {
        Vehiculo foundVehicle;

        foundVehicle = vehiculosList.stream().filter((x) -> x.getPatente().equals(unaPatente)).findFirst().orElse(null);
        if (foundVehicle == null)
        {
            System.out.println("Vehiculo no encontrado");
            return;
        }
        System.out.println("Eliminando");
        System.out.println(foundVehicle);
        vehiculosList.remove(foundVehicle);
    }

    public Vehiculo ganadorCarrera()
    {
//    Velocidad * 1⁄2 Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
        Vehiculo ganador;
        ganador = vehiculosList.stream().max(new SpeedComp()).orElse(null);
        System.out.println("El ganador es:");
        System.out.println(ganador);
        return ganador;
    }

    public void socorrerAuto(String patente)
    {
        Vehiculo vehiculo;
        vehiculo = vehiculosList.stream().filter((x) -> x.getPatente().equals(patente)).findFirst().orElse(null);
        if (vehiculo != null && vehiculo instanceof Auto)
            socorristaAuto.socorrer((Auto) vehiculo);
        else
            System.out.println("No encontrado el carro para socorrer");
    }

    public void socorrerMoto(String patente)
    {
        Vehiculo vehiculo;
        vehiculo = vehiculosList.stream().filter((x) -> x.getPatente().equals(patente)).findFirst().orElse(null);
        if (vehiculo instanceof Moto)
            socorristaMoto.socorrer((Moto) vehiculo);
        else
            System.out.println("No encontrada la moto para socorrer");
    }
}
