import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda p1 = new Prenda("Zara", "Jean");
        Prenda p2 = new Prenda("Levis", "Remera");
        Prenda p3 = new Prenda("Nike", "Zapatilla");

        List<Prenda> lista = Arrays.asList(p1,p2,p3);

        GuardaRopa guardaRopa = new GuardaRopa();

        Integer id = guardaRopa.guardarPrendas(lista);

        System.out.println("El identificador es: " + id);

        List<Prenda> lista2 = Arrays.asList(p1,p3);

        Integer id2 = guardaRopa.guardarPrendas(lista2);
        System.out.println("===========================");
        System.out.println("El identificador es: " + id2);
        System.out.println("===========================");


        System.out.println("===========================");
        System.out.printf("LAS PRENDAS CON EL IDENTIFICADOR %d SON:\n", (int) id);
        guardaRopa.devolverPrendas(id)
                .forEach(p -> System.out.printf("Marca: %s, Modelo: %s.\n", p.getMarca(),p.getModelo()));

        System.out.println("===========================");
        System.out.println("TODAS LAS PRENDAS SON");
        guardaRopa.mostrarPrendas();

    }
}

