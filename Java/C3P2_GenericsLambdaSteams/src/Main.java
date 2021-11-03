import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Vehiculo> vehiculos = new ArrayList<>();
        Vehiculo vehiculo = new Vehiculo("Fiesta","ford", 1000);
        vehiculos.add(vehiculo);
        vehiculos.add(new Vehiculo("Focus", "ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garaje garaje = new Garaje(1,vehiculos);
        //System.out.println(vehiculos.get(0).getCosto());

        // Ordena de menor a mayor precio
        System.out.println(vehiculos.toString());
        Collections.sort(vehiculos, new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo o1, Vehiculo o2) {
                return new Integer(o1.getCosto()).compareTo(new Integer(o2.getCosto()));
            }
        });

        System.out.println(vehiculos.toString());


        // Ordena por marca y precio
        System.out.println(garaje.getVehiculos().toString());
        Collections.sort(garaje.getVehiculos(), new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo o1, Vehiculo o2) {
                int datos = new String(o1.getMarca()).compareToIgnoreCase(new String(o2.getMarca()));
                //System.out.println(datos);
                return datos;
            }
        });

        System.out.println(garaje.getVehiculos().toString());
    }
}
