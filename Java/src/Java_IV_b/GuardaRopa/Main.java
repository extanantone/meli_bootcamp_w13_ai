package Java_IV_b.GuardaRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Se crean el guardaropa, las prendas y la lista
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda remera = new Prenda("Nike","Remera");
        Prenda campera = new Prenda("Puma","Campera");
        List<Prenda> listaPrenda = new ArrayList<>();
        listaPrenda.add(remera);
        listaPrenda.add(campera);
        // Se agregan al guardaropa y se guarda el indice
        int index = guardaRopa.guardarPrenda(listaPrenda);
        guardaRopa.mostrarPrendas();
        // Se quitan del guardaropas
        System.out.println(guardaRopa.devolverPrendas(index));
        guardaRopa.mostrarPrendas();
    }
}
