package JAVA.C3.P1.EJ2;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2C3P1 {
    public static void main(String[] args) {
        List<String> listaHab = new ArrayList<String>();
        listaHab.add("Bailar");
        listaHab.add("Cantar");
        persona marina = new persona("Marina", "Santiso", 39620502, listaHab);
        Curriculum c = new Curriculum(2, marina);
        System.out.println(Imprimible.imprimir(c));
    }
}
