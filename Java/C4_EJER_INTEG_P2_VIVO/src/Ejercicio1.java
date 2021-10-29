import Ropa.GuardaRopa;
import Ropa.Prenda;

import java.util.List;

public class Ejercicio1
{
    public static void main(String[] args)
    {
        int codigo;

        Prenda p1 = new Prenda("Adidas", "T1");
        Prenda p2 = new Prenda("Nike", "T1");

        List<Prenda> prendaList = List.of(p1, p2);
        GuardaRopa miCasa = new GuardaRopa();

        System.out.println("Guardar prendas");
        codigo = miCasa.guardarPrendas(prendaList);
        codigo = miCasa.guardarPrendas(prendaList);
        miCasa.mostrarPrendas();

        System.out.printf("Reclamar prendas con codigo %d\n", codigo);
        miCasa.devolverPrendas(codigo);
        miCasa.mostrarPrendas();

    }
}
