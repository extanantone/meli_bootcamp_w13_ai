package com.company;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    Cliente cliente;
    double total;
    List<Reserva> listaReserva;

    public Localizador(Cliente cliente, double total, List<Reserva> listaReserva) {
        this.cliente = cliente;
        this.total = total;
        this.listaReserva = listaReserva;
    }

    public Localizador() {
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

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }
}
