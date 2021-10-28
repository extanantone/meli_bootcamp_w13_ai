package Dakar;

public class SocorristaMoto extends Vehiculo implements Socorrista<Moto>{

    public SocorristaMoto(int velocidad, int aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println(this.getPatente() + " Socorriendo Moto de la patente: " + vehiculo.getPatente());
    }
}
