package Localizador;

import Modelos.Cliente;
import Reservas.Reserva;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double costoTotal;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.costoTotal = calcularCostoTotal();
    }

    private double calcularCostoTotal() {
        return reservas.stream().mapToDouble(Reserva::calcularCosto).sum();
    }

    public double getCostoTotal() {
        this.costoTotal = calcularCostoTotal();
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return "Localizador.Localizador {" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                ", costoTotal=" + costoTotal +
                '}';
    }
}
