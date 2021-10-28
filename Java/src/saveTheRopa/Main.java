package saveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa g = new GuardaRopa();

        Prenda p1 = new Prenda("Zara", "Jean Wideleg");
        Prenda p2 = new Prenda("Rapsodia", "Saco de lana");

        List<Prenda> prendas1 = new ArrayList<>();
        prendas1.add(p1);
        prendas1.add(p2);

        Prenda p3 = new Prenda("Zara", "Camisa Oversize");
        Prenda p4 = new Prenda("Zara", "Short de jean");

        List<Prenda> prendas2 = new ArrayList<>();
        prendas2.add(p3);
        prendas2.add(p4);

        Integer codigo1 = g.guardarPrendas(prendas1);
        Integer codigo2 = g.guardarPrendas(prendas2);

        g.mostrarPrendas();
        g.devolverPrendas(codigo1);
        g.devolverPrendas(codigo2);

    }
}
