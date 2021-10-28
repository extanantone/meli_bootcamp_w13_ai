package com.company.model;

import java.util.List;

public class Factura {
    private Long codigo;
    private Cliente cliente;
    private List<Item> listItem;
    private double total;

    public Factura(Long codigo, Cliente cliente, List<Item> listItem, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listItem = listItem;
        this.total = total;
    }

    public Factura() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListItem() {
        return listItem;
    }

    public void setListItem(List<Item> listItem) {
        this.listItem = listItem;
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
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", listItem=" + listItem +
                ", total=" + total +
                '}';
    }
}
