package PM.SaveTheRopa;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Adidas", "Original");
        Prenda prenda2 = new Prenda("Nike", "Advance");

        List<Prenda> prendas = Arrays.asList(prenda1, prenda2);

        Integer clave = guardaRopa.guardarPrendas(prendas);

        System.out.println("Clave del Guardarropa: " + clave);
        System.out.println("------------------------");
        guardaRopa.mostrarPrendas();
        guardaRopa.devolverPrendas(clave);
    }
}