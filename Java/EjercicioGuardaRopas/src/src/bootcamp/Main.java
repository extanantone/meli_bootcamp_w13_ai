package src.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> misPrendas = new ArrayList<Prenda>();

        Remera r = new Remera("Levis","L");
        Pantalon l = new Pantalon("Levis","32");

        misPrendas.add(r);
        misPrendas.add(l);


        System.out.println("Prendas almacenadas, su ID es: " + guardaRopa.guardarPrendas(misPrendas));

        guardaRopa.mostrarPrendas();

    }


}
