import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda remera = new Prenda("Adidas","Camiseta");
        Prenda gorra = new Prenda("Nike", "Visera");
        List<Prenda> listaPrendas = new ArrayList<Prenda>();
        listaPrendas.add(remera);
        listaPrendas.add((gorra));
        GuardaRopa guardaRopa = new GuardaRopa();
        int id = guardaRopa.guardarPrenda(listaPrendas);
        System.out.println("Tu id es: " + id + '\n');
        guardaRopa.mostrarPrendas();
        List<Prenda> listaDevuelta = guardaRopa.devolverPrendas(id);
        for (Prenda p : listaDevuelta) {
            System.out.println(p.toString());
        }
        guardaRopa.mostrarPrendas();
    }
}
