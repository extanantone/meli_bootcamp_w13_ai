package asteroid;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        System.out.println("Creando juego con blancos en diagonal...");
        ArrayList<Punto> blancos = new ArrayList<>();
        for (Integer i = 0; i < 1; i++) blancos.add(new Punto(i, 10-i));
        Juego asteroid = new Juego(blancos);

        System.out.println("Inscribiendo participantes...");
        Participante juanCarlos = new Participante("Juan Carlos",
                new NaveSimple("Halcón Milenario", new Punto(3,4)));
        ArrayList<Nave> navesDeAdriana = new ArrayList<>();
        navesDeAdriana.add(new NaveSimple("X-Wing", new Punto(1, 1)));
        navesDeAdriana.add(new NaveSimple("Y-Wing", new Punto(5, 5)));
        Participante adriana = new Participante("Adriana", new FlotaNaves(navesDeAdriana));
        asteroid.inscribirParticipante(juanCarlos);
        asteroid.inscribirParticipante(adriana);

        System.out.println("Calculando ganador...");
        Participante ganador = asteroid.calcularGanador();

        System.out.println(String.format("Ganador: %s", ganador.getNombre()));
    }
}
