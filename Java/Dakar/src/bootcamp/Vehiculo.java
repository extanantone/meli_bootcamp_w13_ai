package bootcamp;

public abstract class Vehiculo {

    private double Velocidad;
    private double Aceleracion;
    private double AnguloDeGiro;
    private String Patente;
    private double Peso;
    private int Ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.Velocidad = velocidad;
        this.Aceleracion = aceleracion;
        this.AnguloDeGiro = anguloDeGiro;
        this.Patente = patente;
        this.Peso = peso;
        this.Ruedas = ruedas;
    }

    public double getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.Velocidad = velocidad;
    }

    public double getAceleracion() {
        return Aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.Aceleracion = aceleracion;
    }

    public double getAnguloDeGiro() {
        return AnguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.AnguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String patente) {
        this.Patente = patente;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        this.Peso = peso;
    }

    public int getRuedas() {
        return Ruedas;
    }

    public void setRuedas(int ruedas) {
        this.Ruedas = ruedas;
    }

    public abstract String toString();
}
