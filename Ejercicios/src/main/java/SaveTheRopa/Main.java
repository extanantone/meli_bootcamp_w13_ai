package SaveTheRopa;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda = new Prenda("Flor de Camisa", "Flores");
        List<Prenda> blenki = Arrays.asList(prenda,
                new Prenda("New Balance", "Ws 237"),
                new Prenda ("Nike", "pantalon"),
                new Prenda("Himawari", "mochila"));

        Integer PrendaGuardada = guardaRopa.guardarPrendas(blenki);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendas = guardaRopa.devolverPrendas(PrendaGuardada);

        guardaRopa.mostrarPrendas();

        System.out.println(guardaRopa.getDiccionario());
    }
}
