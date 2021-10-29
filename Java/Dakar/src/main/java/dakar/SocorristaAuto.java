package dakar;

public class SocorristaAuto extends Socorrista{

    public SocorristaAuto(String patente, Double velocidadSocorro) {
        super(patente, velocidadSocorro);
    }

    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo auto " + String.valueOf(vehiculo.getPatente()));
    }
    public void socorrerAuto(String patente) {
        System.out.println("Socorriendo auto " + patente);
    }
}
