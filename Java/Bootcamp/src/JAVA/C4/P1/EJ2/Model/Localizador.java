package JAVA.C4.P1.EJ2.Model;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    int Identificador;
    List<Reserva> listaReservas = new ArrayList<>();
    Cliente cliente;
    double totalPagar;

    public Localizador(int identificador, List<Reserva> listaReservas, Cliente cliente) {
        Identificador = identificador;
        this.listaReservas = listaReservas;
        this.cliente = cliente;
        this.totalPagar = calcularTotal();
    }

    public double calcularTotal(){
        return this.listaReservas.stream()
                .mapToDouble(r -> r.getCantidad() * r.getPrecioUnitario())
                .sum();
    }

    public int getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(int identificador) {
        Identificador = identificador;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "Identificador=" + Identificador +
                ", listaReservas=" + listaReservas +
                ", cliente=" + cliente +
                ", totalPagar=" + totalPagar +
                '}';
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
}
