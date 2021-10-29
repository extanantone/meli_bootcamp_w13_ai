package dakar;

public class SocorristaMoto extends Socorrista{

    public SocorristaMoto(String patente, Double velocidadSocorro) {
        super(patente, velocidadSocorro);
    }

    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo moto " + String.valueOf(vehiculo.getPatente()));
    }
    public void socorrerAuto(String patente) {
        System.out.println("Socorriendo moto " + patente);
    }
}
