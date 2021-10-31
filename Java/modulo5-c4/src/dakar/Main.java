package dakar;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        System.out.println("Se preparan los competidores del Dakar:");
        Carrera dakarg = new Carrera(5000, 3,
                "Dakar Argentina 2020", 4);
        dakarg.darDeAltaAuto(70, 15, 5, "HER813");
        dakarg.darDeAltaAuto(150, 20, 15, "MAC076");
        dakarg.darDeAltaMoto(130, 22, 30, "HAR800");
        dakarg.darDeAltaMoto(135, 20, 27, "SCO738");
        System.out.println(dakarg);
        System.out.println("Están por arrancar y... alguien llegó tarde:");
        dakarg.darDeAltaMoto(170, 30, 50, "GHO098");
        System.out.println("Una pena...\nMomento, alguien quiere darse de baja:");
        dakarg.eliminarVehiculoConPatente("SCO738");
        System.out.println("Ok, ¿se dio de baja?");
        dakarg.eliminarVehiculo(new Vehiculo(135, 20, 27,
                "SCO738", 500, 2));
        System.out.println("Bien, nuevo arranque entonces.");
        dakarg.darDeAltaMoto(170, 30, 50, "GHO098");
        System.out.println("3...2...1... Terminó, ha ganado:");
        System.out.println(dakarg.obtenerGanador());
        System.out.println("Felicitaciones y... oh, parece ser que hay una serie de vehìculos " +
                "por socorrer en la pista:");
        dakarg.socorrerAuto("HER813");
        dakarg.socorrerMoto("SCO738");
        System.out.println("Esta ha sido la jornada :)");
    }
}
