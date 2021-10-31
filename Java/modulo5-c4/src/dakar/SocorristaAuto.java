package dakar;

public class SocorristaAuto implements Socorrista<Auto>{
    protected Vehiculo vehiculo;

    public SocorristaAuto(Vehiculo inVehiculo) {
        this.vehiculo = inVehiculo;
    }

    public void socorrer(Auto unAuto) {
        System.out.println(String.format("Socorriendo auto %s", unAuto.getPatente()));
    }
}
