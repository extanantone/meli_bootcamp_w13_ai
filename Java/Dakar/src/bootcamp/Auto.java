package bootcamp;

public class Auto extends Vehiculo{
    public static final double PESO = 1000;
    public static final int CANT_RUEDAS = 4;

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, CANT_RUEDAS);
    }

    @Override
    public String toString(){
        return "Auto " + getPatente();
    }
}
