import vehiculos.Auto;
import vehiculos.Moto;
import vehiculos.Vehiculo;
import vehiculos.VehiculoSocorrista;

public class SocorristaMoto extends VehiculoSocorrista {

    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Estoy socorriendo a una moto con patente: " + vehiculo.getPatente());
    }


}
