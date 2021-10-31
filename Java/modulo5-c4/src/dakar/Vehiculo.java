package dakar;

public class Vehiculo {
    protected double velocidad;
    protected double aceleracion;
    protected double anguloDeGiro;
    protected String patente;
    protected double peso;
    protected Integer ruedas;

    public Vehiculo(double inVelocidad, double inAceleracion, double inAnguloDeGiro,
                    String inPatente, double inPeso, Integer inRuedas) {
        this.velocidad = inVelocidad;
        this.aceleracion = inAceleracion;
        this.anguloDeGiro = inAnguloDeGiro;
        this.patente = inPatente;
        this.peso = inPeso;
        this.ruedas = inRuedas;
    }

    public double getVelocidad() {
        return this.velocidad;
    }

    public double getAceleracion() {
        return this.aceleracion;
    }

    public double getAnguloDeGiro() {
        return this.anguloDeGiro;
    }

    public String getPatente() {
        return this.patente;
    }

    public double getPeso() {
        return this.peso;
    }

    public double getRuedas() {
        return this.ruedas;
    }

    public String toString() {
        return String.format("* Velocidad: %f\n Aceleración: %f\n" +
                "* Ángulo de giro: %f\n* Patente: %s\n* Peso: %f\n* Ruedas: %d",
                this.velocidad, this.aceleracion, this.anguloDeGiro, this.patente,
                this.peso, this.ruedas);
    }
}
