package descuentos;

import java.util.ArrayList;
import java.util.HashMap;

public class Registro {
    ArrayList<Repositorio> repositoriosVendidos;

    public Registro() {
        this.repositoriosVendidos = new ArrayList<>();
    };

    public void nuevoRepoVendido(Repositorio inRepo) {
        this.repositoriosVendidos.add(inRepo);
    }

    public int cantLocaliVendidos() {
        return this.repositoriosVendidos.size();
    }

    public int cantTotalReservas() {
        int cantReservas = 0;
        for(Repositorio r : this.repositoriosVendidos) {
            cantReservas+=r.locali.reservas.size();
        }
        return cantReservas;
    }

    public HashMap<String,Integer> cantReservasVendidasPorTipo() {
        HashMap<String,Integer> diccReservas = new HashMap<>();
        diccReservas.put("Hotel", 0);
        diccReservas.put("Comida", 0);
        diccReservas.put("Viaje", 0);
        diccReservas.put("Transporte", 0);
        for(Repositorio r1 : this.repositoriosVendidos) {
            for(Reserva r2 : r1.locali.reservas) {
                int contadorRes = diccReservas.get(r2.toString());
                contadorRes++;
                diccReservas.put(r2.toString(), contadorRes);
            }
        }
        return diccReservas;
    }

    public double totalVentas() {
        return this.repositoriosVendidos.stream().mapToDouble(r->r.totalConDesc).sum();
    }

    public double promedioVentas() {
        return this.repositoriosVendidos.stream().mapToDouble(r->r.totalConDesc).average().orElse(-1);
    }
}
