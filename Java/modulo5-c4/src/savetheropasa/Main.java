package savetheropasa;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        GuardaRopa guarda = new GuardaRopa();
        System.out.println("Javi guardando una remera y un jean");
        ArrayList<Prenda> prendasDeJavi = new ArrayList<>();
        prendasDeJavi.add(new Prenda("Macowens", "Chomba"));
        prendasDeJavi.add(new Prenda("Tommy Hilfiger", "Jean"));
        Integer ticketDeJavi = guarda.guardarPrendas(prendasDeJavi);

        System.out.println("¿Qué guardó Javi?");
        guarda.mostrarPrendas();

        System.out.println("Javi reclamando prendas");
        ArrayList<Prenda> prendasDevueltas = (ArrayList<Prenda>) guarda.devolverPrendas(ticketDeJavi);

        System.out.println("¿Qué quedó en el guardarropas?");
        guarda.mostrarPrendas();
    }
}
