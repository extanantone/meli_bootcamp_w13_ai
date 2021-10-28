package C4.ejercicioIntegradoresP2.saveTheRopa;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda camisa = new Prenda("cara","XL");
        Prenda chaqueta = new Prenda("chevignon", "XS");

        Guardaropa guardaRopa = new Guardaropa();
        Integer ticket = guardaRopa.guardarPrendas(List.of(camisa, chaqueta));

        System.out.println("---Guardarropa---");
        guardaRopa.mostrarPrendas();

        System.out.println("----Sacando ropa de casillero----");
        List<Prenda> prendas = guardaRopa.devolverPrendas(ticket);
        System.out.println("Prendas recibidas");
        prendas.stream().forEach(System.out::println);

        System.out.println("---Guardarropa---");
        guardaRopa.mostrarPrendas();

    }
}
