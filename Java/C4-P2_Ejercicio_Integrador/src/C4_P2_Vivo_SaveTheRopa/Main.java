package C4_P2_Vivo_SaveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardarRopa a = new GuardarRopa();
        List<Prenda> prendas = new ArrayList<>();
        Prenda camper = new Prenda("Tommy", "Nuevo");
        Prenda carter = new Prenda("Channel", "ultimo");
        prendas.add(camper);
        prendas.add(carter);

        int codi = a.guardarPrendas(prendas);
        a.MostrarPrenda();
        System.out.println("Quiero mis prendas: ");
        System.out.println(a.devolverPrendas(codi));
    }
}
