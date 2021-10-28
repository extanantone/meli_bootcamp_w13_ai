package com.Meli.Supermercado.Entity;

import java.util.List;

public class Factura {
    private int nro;
    private Cliente cliente;
    private List<Producto> items;
    private double total;

    public Factura(int nro, Cliente cliente, List<Producto> items, double total) {
        this.nro = nro;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getItems() {
        return items;
    }

    public void setItems(List<Producto> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "nro=" + nro +
                ", cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
