package C3.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje objGaraje = new Garaje("123");

        List<Vehiculo> listVehiculos = new ArrayList<>();

       // listVehiculos = objGaraje.getVehiculos();
        listVehiculos.add(new Vehiculo("Fiesta","ford",1000));
        listVehiculos.add(new Vehiculo("Focus","ford",1200));
        listVehiculos.add(new Vehiculo("Explorer","ford",2500));
        listVehiculos.add(new Vehiculo("Aveo","Chevrolet",1250));
        listVehiculos.add(new Vehiculo("Spin","Chevrolet",2500));
        listVehiculos.add(new Vehiculo("Corola","Toyota",1200));

        objGaraje.setVehiculos(listVehiculos);

        listVehiculos.stream().sorted((x,y) -> {
            if (x.getCosto() < y.getCosto()){
                return -1;
            }
            else if(x.getCosto() > y.getCosto()){
                return 1;
            }
            else{
                return 0;
            }
        } ).forEach(x -> System.out.println(x.getModelo() + " " + x.getCosto()));

        listVehiculos.stream().sorted((x,y) -> {
            if (x.getCosto() < y.getCosto() && (x.getMarca().compareTo(y.getMarca())) < 0 ){
                return -1;
            }
            else if(x.getCosto() > y.getCosto()){
                return 1;
            }
            else{
                return 0;
            }
        } )
                .forEach(x -> System.out.println(x.getModelo() + " " + x.getCosto()));

    }
}
