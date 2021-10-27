import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Hola a todos");

        Garaje mGaraje= new Garaje();

        String[] modelo= {"Ford", "Ford", "Ford", "Fiat", "Fiat", "Fiat", "Chevrolet", "Chevrolet", "Toyota", "Toyota", "Renault"};
        String[] marca= {"Fiesta", "Focus", "Explorer", "Uno", "Cronos", "Torino", "Aveo", "Sprin", "Corola", "Fortuner", "Logan"};
        int[] precio= {1000, 1200, 2500, 500, 1000, 1250, 1250, 2500, 1200, 3000, 950};

        List<Vehiculo> mListTemp= new ArrayList<>();
        for (int i=0; i< marca.length; i++){
            mListTemp.add(new Vehiculo(marca[i], modelo[i], precio[i]));
        }

        mGaraje.setListaVehiculos(mListTemp);

        mGaraje.getListaVehiculos().stream()
                .sorted(Comparator.comparing(vehiculo -> vehiculo.costo))
                .forEach(System.out::println);

        System.out.println("*++++++++++**++++++++++**++++++++++**++++++++++*");

        mGaraje.getListaVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("*++++++++++**++++++++++**++++++++++**++++++++++*");

        List<Vehiculo> mList= new ArrayList<>();
        List<Vehiculo> mList2= new ArrayList<>();

        mGaraje.getListaVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .forEach(mList::add);

        mGaraje.getListaVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(mList2::add);

        /*
        * Obtenemos el promedio mapeando la lista con un stream y obteniendo el promedio
        * */
        /*mGaraje.getListaVehiculos().stream()
                .mapToInt(Vehiculo::getCosto)
                .forEach(System.out::println);*/

        System.out.println("El promedio total de costos es: " + mGaraje.getListaVehiculos().stream()
                .mapToInt(Vehiculo::getCosto)
                .average().getAsDouble());

    }
}