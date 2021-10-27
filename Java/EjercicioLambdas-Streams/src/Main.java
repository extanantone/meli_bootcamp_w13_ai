import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        Vehiculo vehiculo1 = new Vehiculo("Ford","Fiesta",1500);
        Vehiculo vehiculo2 = new Vehiculo("Ford","Focus",2500);
        Vehiculo vehiculo3 = new Vehiculo("Fiat","Argo",5000);
        Vehiculo vehiculo4 = new Vehiculo("Fiat","Cronos",2500);
        Vehiculo vehiculo5 = new Vehiculo("Toyota","Corolla",3000);

        Garage garage = new Garage(1);

        garage.agregarVehiculoAGarage(vehiculo1);
        garage.agregarVehiculoAGarage(vehiculo2);
        garage.agregarVehiculoAGarage(vehiculo3);
        garage.agregarVehiculoAGarage(vehiculo4);
        garage.agregarVehiculoAGarage(vehiculo5);

        vehiculos = garage.getVehiculos();


        vehiculos.stream().sorted((x,y) -> {
                if(x.getPrecio() > y.getPrecio())
                    return 1;
                else if( x.getPrecio() < y.getPrecio())
                    return -1;
                else
                    return 0;
        }).forEach(System.out::println);

        vehiculos.stream()
                .sorted((x,y) -> x.getMarca().compareTo(y.getMarca()))
                .sorted((x,y) -> {
                            if(x.getMarca().equals(y.getMarca())){
                                if(x.getPrecio() > y.getPrecio())
                                    return 1;
                                else if( x.getPrecio() < y.getPrecio())
                                    return -1;
                                else
                                    return 0;
                            }
                    return 0;
                }).forEach(System.out::println);

        vehiculos.stream()
                .filter( x -> x.getPrecio() <= 1500)
                .forEach(System.out::println);

        vehiculos.stream()
                .filter( x -> x.getPrecio() >= 3000)
                .forEach(System.out::println);

        System.out.println(vehiculos.stream().mapToDouble(number -> number.getPrecio())
                .average().getAsDouble());


    }


}
