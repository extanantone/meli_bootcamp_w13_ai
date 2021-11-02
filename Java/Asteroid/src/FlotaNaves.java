import java.util.List;

public class FlotaNaves extends Nave {
    private List<Nave> flota;

    public FlotaNaves(List<Nave> flota) {
        this.flota = flota;
        this.puntos = 0;
    }

    @Override
    public double obtenerDistanciaA(double x, double y) {
        return this.flota.stream().mapToDouble(n->n.obtenerDistanciaA(x,y)).average().orElse(-1);
    }
}
