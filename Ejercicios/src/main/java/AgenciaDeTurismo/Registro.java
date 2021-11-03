package AgenciaDeTurismo;

import java.util.ArrayList;
import java.util.HashMap;

public class Registro {

    ArrayList<Repositorio> repositoriosVendidos;

    public Registro() {
        this.repositoriosVendidos = new ArrayList<>();
    }

    ;

    public void nuevoRepoVendido(Repositorio repositorio) {
        this.repositoriosVendidos.add(repositorio);
    }

    public int cantidadLocalizadoresVendidos() {
        return this.repositoriosVendidos.size();
    }

    public int cantTotalReservas() {
        int cantReservas = 0;
        for (Repositorio r : this.repositoriosVendidos) {
            cantReservas += r.localizador.reservas.size();
        }
        return cantReservas;
    }

    public HashMap<String, Integer> cantReservasPorTipo() {
        HashMap<String, Integer> diccReservas = new HashMap<>();
        diccReservas.put("Hotel", 0);
        diccReservas.put("Comida", 0);
        diccReservas.put("Viaje", 0);
        diccReservas.put("Transporte", 0);
        for (Repositorio r1 : this.repositoriosVendidos) {
            for (Reserva r2 : r1.localizador.reservas) {
                int cantActual = diccReservas.get(r2.toString());
                cantActual++;
                diccReservas.put(r2.toString(), cantActual);
            }
        }
        return diccReservas;
    }

    public double totalVentas() {
       return this.repositoriosVendidos.stream().mapToDouble
               (r -> r.totalConDescuento).sum();
    }

    public double promedioVentas() {
        return this.repositoriosVendidos.stream().mapToDouble
                (r -> r.totalConDescuento).average().orElse(-1);
    }

}

