package AgenciaDeTurismo;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Registro reg = new Registro();

        System.out.println("Caso paquete completo (compra de Marcos)");
        Cliente marcos = new Cliente("Marcos", "Suarez", "34832231");
        ArrayList<Reserva> reservasDeMarcos = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            reservasDeMarcos.add(new Reserva(i+1));
        }
        Localizador paqueteDeMarcos = new Localizador(reservasDeMarcos, marcos, 1000);
        Repositorio repoDeMarcos = new Repositorio(paqueteDeMarcos);
        System.out.println(repoDeMarcos.imprimirCompra());
        reg.nuevoRepoVendido(repoDeMarcos);

        System.out.println("Caso viaje de Marcos");
        ArrayList<Reserva> nuevasReservasDeMarcos = new ArrayList<>();
        nuevasReservasDeMarcos.add(new Reserva(1));
        nuevasReservasDeMarcos.add(new Reserva(1));
        nuevasReservasDeMarcos.add(new Reserva(3));
        nuevasReservasDeMarcos.add(new Reserva(3));
        Localizador viajeDeMarcos = new Localizador(nuevasReservasDeMarcos, marcos, 2*600);
        Repositorio repoViajeDeMarcos = new Repositorio(viajeDeMarcos);
        System.out.println(repoViajeDeMarcos.imprimirCompra());
        reg.nuevoRepoVendido(repoViajeDeMarcos);

        System.out.println("Caso una resrva más para Marcos");
        ArrayList<Reserva> unaReservaMas = new ArrayList<>();
        unaReservaMas.add(new Reserva(1));
        Localizador reservaUnitDeMarcos = new Localizador(unaReservaMas, marcos, 300);
        Repositorio repoUnitDeMarcos = new Repositorio(reservaUnitDeMarcos);
        System.out.println(repoUnitDeMarcos.imprimirCompra());
        reg.nuevoRepoVendido(repoUnitDeMarcos);

        System.out.print("Cantidad de localizadores cendidos: ");
        System.out.println(reg.cantidadLocalizadoresVendidos());
        System.out.print("Cantidad total de reservas: ");
        System.out.println(reg.cantTotalReservas());
        System.out.println("Diccionario de reservas vendidas por tipo:");
        HashMap<String,Integer> diccReservas = reg.cantReservasPorTipo();
        System.out.println("Hotel: " + diccReservas.get("Hotel"));
        System.out.println("Comida: " + diccReservas.get("Comida"));
        System.out.println("Viaje: " + diccReservas.get("Viaje"));
        System.out.println("Transporte: " + diccReservas.get("Transporte"));
        System.out.print("Total de ventas: ");
        System.out.println(reg.totalVentas());
        System.out.print("Promedio de ventas: ");
        System.out.println(reg.promedioVentas());
    }
}
