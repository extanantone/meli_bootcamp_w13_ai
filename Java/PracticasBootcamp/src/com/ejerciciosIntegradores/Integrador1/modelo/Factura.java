package com.ejerciciosIntegradores.Integrador1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private  long codigo;
    private List<Producto> productos = new ArrayList<>();
    private Cliente cliente;
    private double total;

    public Factura(long codigo, List<Producto> productos, Cliente cliente, double total) {
        this.codigo = codigo;
        this.productos = productos;
        this.cliente = cliente;
        this.total = total;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
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

    //private Factura factura;



}
