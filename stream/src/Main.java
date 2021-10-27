import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> lista = new ArrayList();
        List<String> lista2 = new ArrayList<>();

        lista2.add("Juan");
        lista2.add("Pedro");
        lista2.add("Jose");



        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 10000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);

        lista.add(v1);
        lista.add(v2);
        lista.add(v3);

        Garaje garaje1 = new Garaje(1017202476);
        garaje1.setLista(lista);

        for (Vehiculo v: garaje1.getLista() ){
            System.out.println(v.getMarca());
        }
        System.out.println("____");
        lista2.stream().forEach(System.out::println);
        System.out.println("____");
        garaje1.getLista().stream().forEach(System.out::println);
        System.out.println("____");
        garaje1.getLista().stream().filter(x -> x.getMarca().equals("Focus")).forEach(System.out::println);
        System.out.println("____");
        garaje1.getLista().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("____");
        garaje1.getLista().stream().sorted(Comparator.comparing(Vehiculo::getCosto).reversed()).forEach(System.out::println);
        System.out.println("____");
        garaje1.getLista().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach((System.out::println));
        System.out.println("____");
        garaje1.getLista().stream().filter(vehiculo -> vehiculo.getCosto() < 2000).forEach(System.out::println);
        System.out.println("____");
        System.out.println(garaje1.getLista().stream().mapToDouble(Vehiculo::getCosto).average().orElse(-1));

        System.out.println(garaje1.getLista().stream().collect(Collectors.summarizingDouble(v -> v.getCosto())).getAverage());











    }
}
