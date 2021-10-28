package Dakar;

public class SocorristaAuto extends Vehiculo implements Socorrista<Auto>{

    public SocorristaAuto(int velocidad, int aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println(this.getPatente() + " Socorriendo Auto de la patente: " + vehiculo.getPatente());
    }
}
