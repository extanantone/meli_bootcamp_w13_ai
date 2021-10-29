public abstract class Vehiculo {
    Double velocidad,aceleracion,anguloDeGiro,peso;
    String patente;
    Integer ruedas;

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloDeGiro, Double peso, String patente, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.peso = peso;
        this.patente = patente;
        this.ruedas = ruedas;
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

    public Double getValorFormula(){
        return ((this.velocidad * 0.5 * this.aceleracion)/(this.anguloDeGiro*(this.peso-(this.ruedas*100))));
    }
}
