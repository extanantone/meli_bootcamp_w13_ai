package com.company;

import java.util.List;

public class Localizador {
    List<Reserva> reservas;
    Cliente cliente;

    public Localizador(List<Reserva> reservas, Cliente cliente) {
        this.reservas = reservas;
        this.cliente = cliente;
    }

    public double getTotal(){
        return reservas.stream().mapToDouble(Reserva::getPrecio).sum();
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                ", cliente=" + cliente +
                '}';
    }
}
