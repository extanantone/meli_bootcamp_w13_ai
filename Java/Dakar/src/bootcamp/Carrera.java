package bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {

    private double Distancia;
    private double PremioEnDolares;
    private String Nombre;
    private int CantidadDeVehiculosPermitidos;
    private List<Vehiculo> ListaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaVehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.Distancia = distancia;
        this.PremioEnDolares = premioEnDolares;
        this.Nombre = nombre;
        this.CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.ListaVehiculos = listaVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.Distancia = distancia;
        this.PremioEnDolares = premioEnDolares;
        this.Nombre = nombre;
        this.CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.ListaVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    //no se puede dar de alta a 2 autos con la misma patente
    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(this.CantidadDeVehiculosPermitidos > getCantVehiculosInscriptos()){
            boolean esNuevo = this.ListaVehiculos.stream().filter((x) -> x.getPatente().equals(patente)).count() == 0;
            if(esNuevo){
                this.ListaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
                System.out.println("Auto inscripto satisfactoriamente");
            }else {
                System.out.println("No es posible inscribir al auto debido a que ya existe un vehiculo con patente " + patente);
            }
        }else{
            System.out.println("No hay cupo disponible para inscribir a un nuevo auto");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(this.CantidadDeVehiculosPermitidos > getCantVehiculosInscriptos()){
            boolean esNuevo = this.ListaVehiculos.stream().filter((x) -> x.getPatente().equals(patente)).count() == 0;
            if(esNuevo){ //si no hay otro con la misma patente ya inscripto
                this.ListaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
                System.out.println("Moto inscripta satisfactoriamente");
            }else {
                System.out.println("No es posible inscribir a la moto debido a que ya existe un vehiculo con patente " + patente);
            }
        }else{
            System.out.println("No hay cupo disponible para inscribir a una nueva moto");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(this.ListaVehiculos.remove(vehiculo)){
            System.out.println("Se eliminó correctamente al vehículo: " + vehiculo);
        } else {
            System.out.println("El vehículo: " + vehiculo + " no se encuentra inscripto.");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        List<Vehiculo> vehiculoEliminar = this.ListaVehiculos.stream().filter((x) -> x.getPatente().equals(unaPatente)).collect(Collectors.toList());
        if(vehiculoEliminar.size() == 0){
            System.out.println("El vehiculo con patente " + unaPatente + " no se encuentra inscripto");
        }else{
            vehiculoEliminar.forEach(x -> this.ListaVehiculos.remove(x));
            System.out.println("Se eliminó correctamente al vehículo con patente " + unaPatente);
        }
    }

    public Vehiculo definirGanador(){
        double valorMax = -100000, puntaje;
        Vehiculo vehiculoGanador = this.ListaVehiculos.get(0); //toma el primer vehiculo de la lista por defecto

        for (Vehiculo v : this.ListaVehiculos) {
            puntaje = v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
            if(puntaje > valorMax){
                valorMax = puntaje;
                vehiculoGanador = v;
            }
        }

        return vehiculoGanador;
    }

    public void socorrerAuto(String patente){
        List<Vehiculo> autoSocorrer = this.ListaVehiculos.stream().filter((x)-> x.getPatente().equals(patente) && (x instanceof Auto)).collect(Collectors.toList());
        if(autoSocorrer.size() == 0){ //lista vacia
            System.out.println("No existe un auto con patente " + patente + " para ser socorrido.");
        }else {
            autoSocorrer.forEach((x) -> this.socorristaAuto.socorrer((Auto) x));
        }
    }

    public void socorrerMoto(String patente){
        List<Vehiculo> motoSocorrer = this.ListaVehiculos.stream().filter((x)-> x.getPatente().equals(patente) && (x instanceof Moto)).collect(Collectors.toList());
        if(motoSocorrer.size() == 0){ //lista vacia
            System.out.println("No existe una moto con patente " + patente + " para ser socorrida.");
        }else {
            motoSocorrer.forEach((x) -> this.socorristaMoto.socorrer((Moto) x));
        }
    }

    public int getCantVehiculosInscriptos(){
        return this.ListaVehiculos.size();
    }

    @Override
    public String toString() {
        return "Carrera " + Nombre + "\n" +
                " - Distancia=" + Distancia + "\n" +
                " - PremioEnDolares=" + PremioEnDolares + "\n" +
                " - CantidadDeVehiculosPermitidos=" + CantidadDeVehiculosPermitidos + "\n" +
                " - ListaVehiculos=" + ListaVehiculos + "\n" +
                " - socorristaAuto=" + socorristaAuto + "\n" +
                " - socorristaMoto=" + socorristaMoto;
    }

    public double getDistancia() {
        return Distancia;
    }

    public void setDistancia(double distancia) {
       this.Distancia = distancia;
    }

    public double getPremioEnDolares() {
        return PremioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.PremioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return CantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return ListaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.ListaVehiculos = listaVehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }
}
