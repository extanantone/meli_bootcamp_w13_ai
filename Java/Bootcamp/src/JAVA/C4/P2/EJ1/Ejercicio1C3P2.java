package JAVA.C4.P2.EJ1;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio1C3P2 {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("adidas", "remera");
        Prenda prenda2 = new Prenda("nike", "pantalón");
        List<Prenda> prendaList = new ArrayList<Prenda>();
        prendaList.add(prenda1);
        prendaList.add(prenda2);

        Prenda prenda3 = new Prenda("puma", "zapatillas");
        List<Prenda> prendaList2 = new ArrayList<Prenda>();
        prendaList2.add(prenda3);

        GuardaRopa g = new GuardaRopa();

        g.guardarPrendas(prendaList);
        g.mostrarPrendas();
        g.devolverPrendas(1);

        System.out.println("*******");

        g.guardarPrendas(prendaList2);
        g.mostrarPrendas();
        g.devolverPrendas(2);
    }
}
