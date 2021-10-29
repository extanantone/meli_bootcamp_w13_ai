package JAVA.C4.P2.EJ2;

public abstract class Vehiculo {
    private double velocidad;
    private double acelaracion;
    private double anguloDeGiro;
    private String patente;
    private double peso;
    private int rueda;

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAcelaracion() {
        return acelaracion;
    }

    public void setAcelaracion(double acelaracion) {
        this.acelaracion = acelaracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRueda() {
        return rueda;
    }

    public void setRueda(int rueda) {
        this.rueda = rueda;
    }

    public Vehiculo(double velocidad, double acelaracion, double anguloDeGiro, String patente, double peso, int rueda) {
        this.velocidad = velocidad;
        this.acelaracion = acelaracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.rueda = rueda;
    }

    public double formulaGanador() {
        return (this.getVelocidad() + (this.getAcelaracion() / 2)) / (this.getAnguloDeGiro() * (this.getPeso() - this.getRueda() * 100));
    }
}
