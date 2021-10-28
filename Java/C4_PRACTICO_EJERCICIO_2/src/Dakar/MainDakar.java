package Dakar;

import com.sun.source.tree.Scope;

import java.util.ArrayList;

public class MainDakar {
    public static void main(String[] args) {

        // inicio los datos

        SocorristaMoto soc1 = new SocorristaMoto(100,35,90,"soc1",500,4);
        SocorristaAuto soc2 = new SocorristaAuto(60,12,45,"soc2",1500,6);

        Carrera rally = new Carrera(2000.0,50000,"Rally Dakar",
                        100,new ArrayList<>(),soc2,soc1);

        // corredores

        rally.darAltaMoto(130,50,120,"moto1");
        rally.darAltaMoto(120,70,90,"moto2");
        rally.darAltaMoto(140,65,110,"moto3");
        rally.darAltaAuto(170,45,80,"carro1");
        rally.darAltaAuto(180,40,80,"carro2");

        Vehiculo ganador = rally.definirGanador();
        System.out.println("El ganador de la carrera es: " + ganador);

        Vehiculo vhDanado = rally.getVehiculos().get(4);

        rally.ejecutarSocorro(vhDanado);

    }
}
