package dakar;

public class Moto extends Vehiculo{
    public Moto(String patente, Double velocidad, Double aceleracion, Double anguloDeGiro) {
        super(patente, velocidad, aceleracion, anguloDeGiro);
        this.setPeso(300.0);
        this.setRuedas(2);
    }
}
