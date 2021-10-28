import java.util.List;

public class Main {

    public static void main(String[] args) {

        Prenda camisa = new Prenda("Gucci","XL");
        Prenda chaqueta = new Prenda("Chevignon", "XS");

        GuardaRopa guardaRopa = new GuardaRopa();

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
