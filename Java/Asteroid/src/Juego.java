import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Juego {
    private List<Participante> participantes;
    private List<Ubicacion> blancos;
    private Participante cadete;

    public Juego(List<Ubicacion> inBlancos) {
        this.participantes = new ArrayList<>();
        this.blancos = inBlancos;
        this.cadete = new Participante("Buzz",
                new NaveSimple("UFO", new Ubicacion(0, 0)));
    }

    public void inscribirParticipante(Participante inParticipante) {
        this.participantes.add(inParticipante);
    }

    public Participante calcularGanador() {
        for (Ubicacion blanco : this.blancos) {
            Participante masCercano = this.participantes.stream().min(
                    Comparator.comparing(p->p.getNave().obtenerDistanciaA(blanco.getX(),
                            blanco.getY()))).orElse(this.cadete);
            masCercano.incPuntajeDeNave();
        }
        return this.participantes.stream().max(
                Comparator.comparing(Participante::getPuntajeDeNave)).orElse(this.cadete);
    }
}
