package Darkar;

public abstract class Vehiculo
{
    public Vehiculo(double velocidad, double acelaracion, double angGiro, String patente, double peso, Integer ruedas)
    {
        this.velocidad = velocidad;
        this.aceleracion = acelaracion;
        this.angGiro = angGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public double getVelocidad()
    {
        return velocidad;
    }

    public void setVelocidad(double velocidad)
    {
        this.velocidad = velocidad;
    }

    public double getAceleracion()
    {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion)
    {
        this.aceleracion = aceleracion;
    }

    public double getAngGiro()
    {
        return angGiro;
    }

    public void setAngGiro(double angGiro)
    {
        this.angGiro = angGiro;
    }

    public double getPeso()
    {
        return peso;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public Integer getRuedas()
    {
        return ruedas;
    }

    public void setRuedas(Integer ruedas)
    {
        this.ruedas = ruedas;
    }

    private double velocidad;
    private double aceleracion;
    private double angGiro;
    private String patente;
    private double peso;
    private Integer ruedas;

    public String getPatente()
    {
        return patente;
    }

    public void setPatente(String patente)
    {
        this.patente = patente;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Vehiculo{");
        sb.append("velocidad=").append(velocidad);
        sb.append(", aceleracion=").append(aceleracion);
        sb.append(", angGiro=").append(angGiro);
        sb.append(", patente='").append(patente).append('\'');
        sb.append(", peso=").append(peso);
        sb.append(", ruedas=").append(ruedas);
        sb.append('}');
        return sb.toString();
    }

    public double totalSpeed()
    {
        return velocidad * (1d/2) * aceleracion / angGiro * (peso - ruedas * 100);
    }
}
