import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> misPrendas = new ArrayList<>();

        misPrendas.add(new Prenda("Adidas", "Originals"));
        misPrendas.add(new Prenda("Nike", "Jordan"));
        guardaRopa.guardarPrendas(misPrendas);

        Integer numeroGuardaropa = guardaRopa.guardarPrendas(misPrendas);
        System.out.println("Prendas guardadas, numero de guardaropa: "+numeroGuardaropa);

        System.out.println("----------------Guardaropas actual---------------");
        guardaRopa.mostrarPrendas();
        System.out.println("-------------------------------------------------");

        System.out.println("-----Guardaropas despues de devoler prendas-----");
        guardaRopa.devolverPrendas(numeroGuardaropa);
        guardaRopa.mostrarPrendas();
        System.out.println("------------------------------------------------");
    }
}
