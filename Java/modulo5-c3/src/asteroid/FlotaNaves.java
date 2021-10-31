package asteroid;

import java.util.List;

public class FlotaNaves extends Nave {
    private List<Nave> flota;

    public FlotaNaves(List<Nave> inFlota) {
        this.flota = inFlota;
        this.puntos = 0;
    }

    @Override
    public double obtenerDistanciaA(double inCoordX, double inCoordY) {
        return this.flota.stream().mapToDouble(n->n.obtenerDistanciaA(inCoordX,inCoordY)).average().orElse(-1);
    }
}
