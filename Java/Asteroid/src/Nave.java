public class Nave implements Distancia {
    protected Integer puntos;

    public Integer getPuntos() {
        return this.puntos;
    }

    public void incPuntos() {
        this.puntos++;
    }

    @Override
    public double obtenerDistanciaA(double inCoordX, double inCoordY) {
        return 0;
    }
}
