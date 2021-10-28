package Dakar;

public class Moto extends Vehiculo {

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        peso = 300;
        ruedas = 2;
    }
}
