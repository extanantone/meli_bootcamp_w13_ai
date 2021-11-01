package bootcamp;

public class Moto extends Vehiculo{
    public static final double PESO = 300;
    public static final int CANT_RUEDAS = 2;

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, CANT_RUEDAS);
    }

    @Override
    public String toString(){
        return "Moto " + getPatente();
    }
}
