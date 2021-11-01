package bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> participantes = new ArrayList<>();
        Vehiculo miAuto = new Auto(244.2, 65, 50, "VAC777");
        Vehiculo miMoto = new Moto(180, 70, 60, "CAM321");

        participantes.add(new Auto(230, 50, 45, "ABC123"));
        participantes.add(new Auto(250, 30, 42, "ALE100"));
        participantes.add(new Auto(150, 80, 67, "MAC020"));
        participantes.add(new Auto(200, 75, 90, "GOL999"));
        participantes.add(new Moto(140, 99, 80, "MOT011"));
        participantes.add(new Moto(170, 89, 90, "XYZ123"));
        participantes.add(new Moto(199, 80, 77, "POL333"));
        participantes.add(miAuto);
        participantes.add(miMoto);

        Carrera dakar2021 = new Carrera(2500, 1500000, "Dakar Argentina - Chile - Perú 2021", 20, participantes, new SocorristaAuto(), new SocorristaMoto());

        dakar2021.darDeAltaAuto(234, 70, 50, "AAA111");
        //dakar2021.darDeAltaAuto(233, 50, 50, "AAA111");
        dakar2021.darDeAltaMoto(210, 60, 60, "ASD098");

        System.out.println(dakar2021);

        dakar2021.socorrerAuto("ALE100");
        dakar2021.socorrerMoto("XYZ123");
        //dakar2021.socorrerMoto("ALE100");
        System.out.println( "GANADOR " + dakar2021.getNombre() + " es " + dakar2021.definirGanador());

        dakar2021.eliminarVehiculo(miAuto);
        dakar2021.eliminarVehiculoConPatente("GOL999");
        //dakar2021.eliminarVehiculoConPatente("JAJ707");

        //System.out.println(dakar2021);

        /*
        Auto auto1 = new Auto(300.0, 100.0, 75.0, "AJK 197");
        Carrera granPrixDeEdu = new Carrera(174.5, 1000.0, "Gran Prix de Edu", 3);

        System.out.println("----------------------------------------------------------------------------------");

        granPrixDeEdu.eliminarVehiculo(auto1);
        granPrixDeEdu.darDeAltaAuto(300.0, 100.0, 75.0, "AJK 197");
        granPrixDeEdu.darDeAltaAuto(270.0, 84.0, 90.0, "PPP 223");
        granPrixDeEdu.darDeAltaAuto(270.0, 84.0, 90.0, "PPP 223");

        System.out.println("----------------------------------------------------------------------------------");

        granPrixDeEdu.darDeAltaMoto(150.0, 59.7, 34.2, "MOT 069");
        granPrixDeEdu.darDeAltaMoto(350.0, 7.3, 150.0, "ONE 234");
        granPrixDeEdu.eliminarVehiculoConPatente("MOT 069");
        granPrixDeEdu.darDeAltaMoto(350.0, 7.3, 150.0, "ONE 234");

        System.out.println("----------------------------------------------------------------------------------");

        granPrixDeEdu.socorrerAuto("AJK 197");
        granPrixDeEdu.socorrerAuto("BBB 267");
        granPrixDeEdu.socorrerMoto("MOT 069");
        granPrixDeEdu.socorrerMoto("ONE 234");*/
    }
}
