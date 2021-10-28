package Dakar;


import java.util.List;
import java.util.stream.Collectors;

public class Carrera {

    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantidadVehiculos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socAuto;
    private SocorristaMoto socMoto;

    public Carrera(double distancia, double premioDolares, String nombre, int cantidadVehiculos, List<Vehiculo> vehiculos, SocorristaAuto socAuto, SocorristaMoto socMoto) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculos = cantidadVehiculos;
        this.vehiculos = vehiculos;
        this.socAuto = socAuto;
        this.socMoto = socMoto;
    }

    public void darAltaMoto(int velocidad, int aceleracion, double anguloGiro, String patente) {
        if (cupo()) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente));
        }
    }
    public void darAltaAuto(int velocidad, int aceleracion, double anguloGiro, String patente) {
        if (cupo()) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
        }
    }

    public boolean cupo() {
        return vehiculos.size() < cantidadVehiculos;
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        List<Vehiculo> vehPatente = vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).collect(Collectors.toList());
        vehPatente.stream().forEach(x->this.vehiculos.remove(x));
    }

    public Vehiculo definirGanador(){
        Double valorGanadorTemp = 0.0;
        Vehiculo ganador = null;
        for(Vehiculo corredor:this.vehiculos)
        {
            Double valorCorredor = (corredor.getVelocidad()*corredor.getAceleracion()/2) /
                    (corredor.getAnguloDeGiro()*(corredor.getPeso() - corredor.getRuedas()*100));
            if(valorCorredor>valorGanadorTemp)
            {
                valorGanadorTemp = valorCorredor;
                ganador = corredor;
            }
        }
        return ganador;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(double premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public SocorristaAuto getSocAuto() {
        return socAuto;
    }

    public void setSocAuto(SocorristaAuto socAuto) {
        this.socAuto = socAuto;
    }

    public SocorristaMoto getSocMoto() {
        return socMoto;
    }

    public void setSocMoto(SocorristaMoto socMoto) {
        this.socMoto = socMoto;
    }

    public void ejecutarSocorro(Vehiculo vhDanado){
        try{
            System.out.println("Enviando Socorrista Moto");
            socMoto.socorrer((Moto)vhDanado);
        }catch(ClassCastException e)
        {
            System.out.println("No es el socorrista correcto");
            System.out.println("Enviando Socorrista Autos");
            socAuto.socorrer((Auto)vhDanado);
        }
    }
}