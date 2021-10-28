import Localizador.Localizador;
import Localizador.GestorLocalizador;
import Modelos.Cliente;
import Reservas.*;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente("Lautaro", "Goyenechea", "42218782");

        Localizador l1 = GestorLocalizador.comprarLocalizador(
                c1,
                Arrays.asList(
                        new ReservaPaqueteCompleto(
                                LocalDateTime.now(),
                                new ReservaBoletoViaje(
                                        LocalDateTime.now(),
                                        100,
                                        "Cordoba",
                                        "Mendoza",
                                        1
                                ),
                                new ReservaComida(
                                        LocalDateTime.now(),
                                        1500,
                                        "Palo Verde"
                                ),
                                new ReservaHotel(
                                        LocalDateTime.now(),
                                        5000,
                                        "Hotel Viena",
                                        113
                                ),
                                new ReservaTransporte(
                                        LocalDateTime.now(),
                                        600,
                                        "Mendoza",
                                        "Chile"
                                )
                        )
                )
        );

        System.out.println(l1);

        Localizador l2 = GestorLocalizador.comprarLocalizador(
                c1,
                Arrays.asList(
                        new ReservaBoletoViaje(
                                LocalDateTime.now(),
                                50,
                                "Devoto",
                                "Cordoba",
                                1
                        ),
                        new ReservaBoletoViaje(
                                LocalDateTime.now(),
                                50,
                                "Devoto",
                                "Cordoba",
                                1
                        )
                )
        );

        System.out.println("-------------------");
        System.out.println(l2);

        Localizador l3 = GestorLocalizador.comprarLocalizador(
                c1,
                Arrays.asList(
                        new ReservaComida(
                                LocalDateTime.now(),
                                350,
                                "Homies"
                        )
                )
        );

        System.out.println("-------------------");
        System.out.println(l3);
    }
}
