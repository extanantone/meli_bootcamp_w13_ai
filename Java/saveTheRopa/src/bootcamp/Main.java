package bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("¡Bienvenidos a Save The Ropa!");

        Prenda campera = new Campera("Adidas", "ad025");
        Prenda sweater = new Sweater("Polo", "my polo store");
        List<Prenda> prendasAle = new ArrayList<>();
        prendasAle.add(campera);
        prendasAle.add(sweater);

        GuardaRopa guardarropa = new GuardaRopa();
        Integer codigoAle = guardarropa.guardarPrendas(prendasAle);
        System.out.println("Soy Ale y ya he guardado mis prendas en el guardarropas, mi codigo es " + codigoAle);

        List<Prenda> prendasPepe = new ArrayList<>();
        prendasPepe.add(new Zapatillas("Nike", "thunder"));
        prendasPepe.add(new Campera("Legacy", "winter2021"));

        Integer codigoPepe = guardarropa.guardarPrendas(prendasPepe);
        System.out.println("Soy Pepe y ya he guardado mis prendas en el guardarropas, mi codigo es " + codigoPepe);

        guardarropa.mostrarPrendas();
        guardarropa.devolverPrendas(codigoAle);

        guardarropa.mostrarPrendas();

        List<Prenda> prendasJuan = new ArrayList<>();
        prendasJuan.add(new Zapatillas("Topper", "San ciro"));
        prendasJuan.add(new Sweater("Narrow", "abc123"));

        Integer codigoJuan = guardarropa.guardarPrendas(prendasJuan);
        System.out.println("Soy Juan y ya he guardado mis prendas en el guardarropas, mi codigo es " + codigoJuan);

        guardarropa.mostrarPrendas();
    }
}
