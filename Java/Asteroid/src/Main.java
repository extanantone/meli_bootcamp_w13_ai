import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {

        ArrayList<Ubicacion> blancos = new ArrayList<>();
        for (Integer i = 0; i < 10; i++){
            Double x = Math.random()*1000;
            Double y = Math.random()*1000;
            blancos.add(new Ubicacion(x.intValue(), y.intValue()));
        }
        Juego asteroid = new Juego(blancos);

        System.out.println("Inscribiendo participantes");

        Participante participante1 = new Participante("luke",
                new NaveSimple("Halcón Milenario", new Ubicacion(11,11)));
        ArrayList<Nave> navesDeAdriana = new ArrayList<>();
        navesDeAdriana.add(new NaveSimple("X-Wing", new Ubicacion(3, 22)));
        navesDeAdriana.add(new NaveSimple("Y-Wing", new Ubicacion(11, 4)));
        Participante participante2 = new Participante("yoda", new FlotaNaves(navesDeAdriana));
        asteroid.inscribirParticipante(participante1);
        asteroid.inscribirParticipante(participante2);

        System.out.println("Calculando ganador");
        Participante ganador = asteroid.calcularGanador();

        System.out.println("El ganador es: " + ganador.getNombre());
    }
}
