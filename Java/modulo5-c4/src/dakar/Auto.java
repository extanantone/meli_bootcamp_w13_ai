package dakar;

public class Auto extends Vehiculo{
    public Auto(double inVelocidad, double inAceleracion,
                double inAnguloDeGiro, String inPatente) {
        super(inVelocidad, inAceleracion, inAnguloDeGiro, inPatente, 1000, 4);
    }
}
