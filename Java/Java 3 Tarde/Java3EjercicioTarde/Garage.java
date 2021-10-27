package Java3EjercicioTarde;

import java.util.ArrayList;

public class Garage {
    private static int proximoId = 0;
    private int id;
    private ArrayList<Vehiculo> vehiculos;

    public Garage(ArrayList<Vehiculo> vehiculos) {
        this.id = proximoId++;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}

//        .sorted(Comparator.comparing(Vehiculo::getCosto))
//        .forEach(p -> System.out.println(p.getCosto()));