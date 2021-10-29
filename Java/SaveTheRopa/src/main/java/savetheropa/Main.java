package savetheropa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> listaPersona1 = new ArrayList<>();
        listaPersona1.add(new Prenda("Gucci", "La más aspera"));
        listaPersona1.add(new Prenda("Dolce & Gabana", "La segunda más aspera"));
        Integer identificador = guardaRopa.guardarPrendas(listaPersona1);
        System.out.println(identificador);
        guardaRopa.mostrarPrendas();
        System.out.println("Recogiendo las prendas:");
        System.out.println(guardaRopa.devolverPrendas(identificador));
    }
}
