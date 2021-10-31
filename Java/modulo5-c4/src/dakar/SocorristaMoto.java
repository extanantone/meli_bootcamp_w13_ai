package dakar;

public class SocorristaMoto implements Socorrista<Moto>{
    protected Vehiculo vehiculo;

    public SocorristaMoto(Vehiculo inVehiculo) {
        this.vehiculo = inVehiculo;
    }

    public void socorrer(Moto unaMoto) {
        System.out.println(String.format("Socorriendo moto %s", unaMoto.getPatente()));
    }
}