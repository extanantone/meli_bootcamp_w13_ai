import vehiculos.Auto;
import vehiculos.Vehiculo;
import vehiculos.VehiculoSocorrista;

public class SocorristaAuto extends VehiculoSocorrista {


    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Estoy socorriendo a un auto con patente: " + vehiculo.getPatente());
    }
}
