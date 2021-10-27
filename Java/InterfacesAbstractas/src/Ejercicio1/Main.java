package Ejercicio1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vehiculo> lista = new ArrayList<>();
        lista.add(new Vehiculo("ford","fiesta", 1000));
        lista.add(new Vehiculo("ford","focus", 1200));
        lista.add(new Vehiculo("ford","explorer", 2500));
        lista.add(new Vehiculo("fiat","uno", 500));
        lista.add(new Vehiculo("fiat","cronos", 1000));
        lista.add(new Vehiculo("fiat","torino", 1250));
        lista.add(new Vehiculo("chevrolet","aveo", 1250));
        lista.add(new Vehiculo("chevrolet","spin", 2500));
        lista.add(new Vehiculo("toyota","corola", 1200));
        lista.add(new Vehiculo("toyota","fortuner", 3000));
        lista.add(new Vehiculo("renault","logan", 950));

        Garaje garaje = new Garaje(1, lista);
            /*garaje.sort();
            garaje.sortMarcaAndPrice();*/
            garaje.getPromedio();

    }
}
