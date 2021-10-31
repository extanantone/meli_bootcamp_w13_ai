package asteroid;

public class NaveSimple extends Nave {
    private String nombre;
    private Punto ubicacion;

    public NaveSimple(String inNombre, Punto inUbicacion) {
        this.nombre = inNombre;
        this.ubicacion = inUbicacion;
        this.puntos = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getCoordX() {
        return this.ubicacion.getCoordX();
    }

    public double getCoordY() {
        return this.ubicacion.getCoordY();
    }

    @Override
    public double obtenerDistanciaA(double inCoordX, double inCoordY) {
        return (this.getCoordX() - inCoordX) * (this.getCoordX() - inCoordX) +
                (this.getCoordY() - inCoordY) * (this.getCoordY() - inCoordY);
    }
}
