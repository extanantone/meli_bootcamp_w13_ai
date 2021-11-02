public class NaveSimple extends Nave {
    private String nombre;
    private Ubicacion ubicacion;

    public NaveSimple(String inNombre, Ubicacion ubicacion) {
        this.nombre = inNombre;
        this.ubicacion = ubicacion;
        this.puntos = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getCoordX() {
        return this.ubicacion.getX();
    }

    public double getCoordY() {
        return this.ubicacion.getY();
    }

    @Override
    public double obtenerDistanciaA(double inCoordX, double inCoordY) {
        return (this.getCoordX() - inCoordX) * (this.getCoordX() - inCoordX) +
                (this.getCoordY() - inCoordY) * (this.getCoordY() - inCoordY);
    }
}
