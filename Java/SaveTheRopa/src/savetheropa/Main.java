package savetheropa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Adidas", "Camiseta"));
        prendas.add(new Prenda("Puma", "Medias"));

        Integer id = guardaRopa.guardarPrendas(prendas);
        System.out.println(id);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendas1 = guardaRopa.devolverPrendas(id);
        System.out.println(prendas1);

    }
}
