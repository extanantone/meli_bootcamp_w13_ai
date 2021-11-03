import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Prenda> listaDePrendas = new LinkedList<>();
        GuardaRopa ropero = new GuardaRopa();
        listaDePrendas.add(new Prenda("marca", "modelo"));
        ropero.guardarPrendas(listaDePrendas);

        







    }
}
