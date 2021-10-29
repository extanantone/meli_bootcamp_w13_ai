package dakar;

public class Auto extends Vehiculo{

    public Auto(String patente, Double velocidad, Double aceleracion, Double anguloDeGiro) {
        super(patente, velocidad, aceleracion, anguloDeGiro);
        this.setPeso(1000.0);
        this.setRuedas(4);
    }
}
