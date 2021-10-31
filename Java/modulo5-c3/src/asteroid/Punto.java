package asteroid;

public class Punto {
    private double coordX;
    private double coordY;

    public Punto(double inCoordX, double inCoordY) {
        this.coordX = inCoordX;
        this.coordY = inCoordY;
    }

    public double getCoordX() {
        return this.coordX;
    }

    public double getCoordY() {
        return this.coordY;
    }
}
