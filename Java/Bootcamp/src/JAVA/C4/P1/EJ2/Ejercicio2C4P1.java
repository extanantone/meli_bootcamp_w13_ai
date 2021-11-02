package JAVA.C4.P1.EJ2;
/*
Paquete turistico:
        - Reserva de hotel
        - Reserva de comida
        - Reserva boleto de viaje
        - Reserva transporte
Localizadores:
        - Reserva o varias reservas
        - Datos del cliente
        - Total a pagar
LocalizadorRepository:
        - GuardarLocalizador
        - MostrarLocalizador
ClienteRepository:
        - BuscarReservas
        - AplicarDescuento
        - Localizadores >= 2 -> 5% descuento en el total.
        - Paquete completo (reserva hotel, reserva comida, reserva boletos viaje, reserva transporte) -> 10% descuento en el total. 		- Reserva hotel >= 2 | | Reserva boleto viaje -> 5% descuento en precio de cada 			   reserva.
        - BuscarCliente (si no está, agregar cliente)

    1.  a. Crear un localizador con un paquete completo (reserva hotel, reserva comida, reserva boletos viaje, reserva transporte) para un cliente.
        b. Almacenar resultado.
        c. Mostrar resultado.
    2.  a. Crear un localizador con 2 reservas de hotel y 2 boletos de viaje para el mismo cliente anterior.
        b. Almacenar resultado.
        c. Mostrar resultado.
    3.  Crear un localizador con una sola reserva para el mismo cliente anterior.
    4.  Verificar que los descuentos fueron aplicados.

    Crear una clase que permita realizar las siguientes consultas:
    5.  Cantidad de localizadores vendidos.
    6.  Cantidad total de reservas.
    7.  Obtener un diccionario de todas las reservas, clasificados por tipo (hotel, boleto, comida, transporte).
    8.  Total de ventas.
    9.  Promedio de todas las ventas.
*/

import JAVA.C4.P1.EJ2.Model.*;
import JAVA.C4.P1.EJ2.Repository.ClienteRepository;
import JAVA.C4.P1.EJ2.Repository.LocalizadorRepository;

import java.util.*;

public class Ejercicio2C4P1 {
    public static void main(String[] args) {
        Cliente c1;
        c1 = new Cliente(39620502, "Marina", "Santiso");

        ClienteRepository cr1;
        cr1 = new ClienteRepository();
        cr1.alta(c1);

        Reserva r1, r2, r3, r4;
        r1 = new ReservaBoletoViaje(1, "Volar", 3, false);
        r2 = new ReservaComida(2, "Riccione", 2, true);
        r3 = new ReservaHotel(3, "Holatel", 1, true);
        r4 = new ReservaTransporte(4, "Redbus", 1, true);

        List<Reserva> listaReserva = new ArrayList<>();
        listaReserva.add(r1);
        listaReserva.add(r2);
        listaReserva.add(r3);
        listaReserva.add(r4);

        //punto 1.a, 1.b y 1.c
        Localizador locPacCom;
        locPacCom = new Localizador(77, listaReserva, c1);

        LocalizadorRepository localizadorRepository = new LocalizadorRepository();
        localizadorRepository.alta(locPacCom);
        localizadorRepository.mostrarGeneral();
        System.out.println(cr1.calcularDescuentoTotal(localizadorRepository.devolverLista()));

        //punto 2.a, 2.b y 2.c
        List<Reserva> listaReserva2 = new ArrayList<>();
        listaReserva2.add(r3);
        listaReserva2.add(r3);
        listaReserva2.add(r1);
        listaReserva2.add(r1);

        Localizador locDescRes;
        locDescRes = new Localizador(88, listaReserva2, c1);
        LocalizadorRepository localizadorRepository2 = new LocalizadorRepository();
        localizadorRepository2.alta(locDescRes);
        localizadorRepository2.mostrarGeneral();
        System.out.println(cr1.calcularDescuentoTotal(localizadorRepository2.devolverLista()));

        //punto 3.a, 3.b y 3c
        List<Reserva> listaReserva3 = new ArrayList<>();
        listaReserva3.add(r4);

        Localizador locSinDesc;
        locSinDesc = new Localizador(99, listaReserva3, c1);
        LocalizadorRepository localizadorRepository3 = new LocalizadorRepository();
        localizadorRepository3.alta(locSinDesc);
        localizadorRepository3.mostrarGeneral();
        System.out.println(cr1.calcularDescuentoTotal(localizadorRepository3.devolverLista()));
    }
}
