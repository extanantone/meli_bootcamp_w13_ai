import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Prenda> listaDePrendas = List.of(
            new Prenda("Nike", "test"),
            new Prenda("Adidas", "test2")
        );

        List<Prenda> listaDePrendas2 = List.of(
                new Prenda("Polo", "test3"),
                new Prenda("Puma", "test4")
        );

        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(listaDePrendas);
        guardaRopa.guardarPrendas(listaDePrendas2);

        guardaRopa.mostrarPrendas();

        System.out.println("//////////");

        guardaRopa.devolverPrendas(2).stream().forEach(System.out::println);
    }
}
