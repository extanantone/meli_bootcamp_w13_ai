package Dakar;

public class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    protected double peso;
    protected int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public double formulaCarrera() {
        return velocidad * (0.5 * aceleracion) / (anguloDeGiro * (peso - ruedas * 100));
    }
}
