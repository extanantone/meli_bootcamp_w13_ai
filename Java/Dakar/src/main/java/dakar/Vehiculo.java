package dakar;

import java.util.regex.PatternSyntaxException;

public class Vehiculo {
    private String patente;
    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private Double peso;
    private Integer ruedas;

    public Vehiculo(String patente, Double velocidad, Double aceleracion, Double anguloDeGiro) {
        this.patente = patente;
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public void setAceleracion(Double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public void setAnguloDeGiro(Double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }
}
