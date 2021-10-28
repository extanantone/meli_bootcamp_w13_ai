package saveRopa;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<Prenda> listaPrendas = new ArrayList<>();

        Prenda prenda1 = new Prenda("zara", "saco");
        Prenda prenda2 = new Prenda("bigjhon", "pantalon");
        Prenda prenda3 = new Prenda("ddd", "dd");

        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);
        listaPrendas.add(prenda3);

        GuardaRopa guarda = new GuardaRopa();


        System.out.println(guarda.guardarPrendas(listaPrendas));
        System.out.println(guarda.guardarPrendas(listaPrendas));
        System.out.println(guarda.guardarPrendas(listaPrendas));

        System.out.println(guarda.devolverPrendas(1));

    }
}
