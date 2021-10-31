package dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    double distancia;
    double premioEnDolares;
    String nombre;
    Integer cantidadDeVehiculosPermitidos;
    List<Vehiculo> vehiculos;
    SocorristaAuto socoAutos;
    SocorristaMoto socoMotos;

    public Carrera(double inDistancia, double inPremioEnDolares, String inNombre,
                   Integer inCantidadDeVehiculosPermitidos) {
        this.distancia = inDistancia;
        this.premioEnDolares = inPremioEnDolares;
        this.nombre = inNombre;
        this.cantidadDeVehiculosPermitidos = inCantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socoAutos = new SocorristaAuto(new Vehiculo(20, 1.5, 0,
                "GRU410", 3000, 8));
        this.socoMotos = new SocorristaMoto(new Vehiculo(22, 1.87, 0,
                "REM171", 2000, 6));
    }

    @Override
    public String toString() {
        String outMsg = String.format("- Distancia: %f\n- Premio en dólares: %f\n",
                this.distancia, this.premioEnDolares);
        outMsg+=String.format("- Nombre: %s\n- Cantidad de vehículos permitidos: %d",
                this.nombre, this.cantidadDeVehiculosPermitidos);
        outMsg+="\n- Competidores:";
        for (Vehiculo v: this.vehiculos) outMsg+="\n" + v.toString();
        outMsg+="\n- Socorristas:";
        outMsg+="\n+ " + this.socoAutos.toString(); // Faltó implementar toString
        outMsg+="\n+ " + this.socoMotos.toString(); // Faltó implementar toString
        return outMsg;
    }

    public void darDeAltaAuto(double inVelocidad, double inAceleracion,
                              double inAnguloDeGiro, String inPatente) {
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            this.vehiculos.add(new Auto(inVelocidad,inAceleracion,inAnguloDeGiro,inPatente));
        } else {
            System.out.println("No hay más cupo.");
        }
    }

    public void darDeAltaMoto(double inVelocidad, double inAceleracion,
                              double inAnguloDeGiro, String inPatente) {
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            this.vehiculos.add(new Moto(inVelocidad,inAceleracion,inAnguloDeGiro,inPatente));
        } else {
            System.out.println("No hay más cupo.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (this.vehiculos.remove(vehiculo)) {
            System.out.println("Vehículo eliminado de la lista.");
        } else {
            System.out.println("El presente vehículo no se encuentra en la lista.");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        if (this.vehiculos.removeIf(v->v.patente.equals(unaPatente))) {
            System.out.println(String.format("Vehículo %s eliminado de la lista.", unaPatente));
        } else {
            System.out.println(String.format("No hay vehículo de patente %s en la lista.", unaPatente));
        }
    }

    public Vehiculo obtenerGanador(){
        Vehiculo vehiculoDefault = new Auto(35,55,11,"AAA-111");
        return this.vehiculos.stream().
                max(Comparator.comparing(v->v.getVelocidad()*0.5*v.getAceleracion()/
                        (v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100)))).orElse(vehiculoDefault);
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo v : this.vehiculos) {
            // Asumo que autos y motos no comparten patente
            if (v.getPatente().equals(patente)) {
                this.socoAutos.socorrer((Auto) v);
            }
        }
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo v : this.vehiculos) {
            // Asumo que autos y motos no comparten patente
            if (v.getPatente().equals(patente)) {
                this.socoMotos.socorrer((Moto) v);
            }
        }
    }
}
