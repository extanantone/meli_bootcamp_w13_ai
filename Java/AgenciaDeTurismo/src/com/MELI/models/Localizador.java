package com.MELI.models;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private double total;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente, ArrayList<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = calcularTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double calcularTotal(){
        return reservas.isEmpty() ? 0 : reservas.stream().mapToDouble(Reserva::getPrecio).sum();
    }
}
