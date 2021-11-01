package com.mercadolibre.Implementacion;

import com.mercadolibre.Enumeradores.EstadoReserva;
import com.mercadolibre.Enumeradores.Producto;

import java.util.Date;
import java.util.List;

public class Reserva {
    private Date fechaInicio;
    private Date fechaFin;
    private List<Producto> Productos;
    private Cliente cliente;
    private EstadoReserva estado;

    public Reserva(Date fechaInicio, Date fechaFin, List<Producto> productos, Cliente cliente) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        Productos = productos;
        this.cliente = cliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(List<Producto> productos) {
        Productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", Productos=" + Productos +
                ", cliente=" + cliente +
                ", estado=" + estado +
                '}';
    }
}
